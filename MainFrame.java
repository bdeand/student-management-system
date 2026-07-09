import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    private StudentManager manager = new StudentManager();

    private JTextField txtId, txtName, txtAge, txtDepartment, txtGpa;
    private JTable table;
    private DefaultTableModel model;

    public MainFrame() {
        setTitle("Student Management System");
        setSize(900,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5,2,10,10));
        form.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        txtId = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtDepartment = new JTextField();
        txtGpa = new JTextField();

        form.add(new JLabel("Student ID"));
        form.add(txtId);
        form.add(new JLabel("Name"));
        form.add(txtName);
        form.add(new JLabel("Age"));
        form.add(txtAge);
        form.add(new JLabel("Department"));
        form.add(txtDepartment);
        form.add(new JLabel("GPA"));
        form.add(txtGpa);

        add(form,BorderLayout.NORTH);

        model = new DefaultTableModel(
                new Object[]{"Student ID","Name","Age","Department","GPA"},0);

        table = new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton addBtn=new JButton("Add");
        JButton updateBtn=new JButton("Update");
        JButton deleteBtn=new JButton("Delete");
        JButton searchBtn=new JButton("Search");
        JButton clearBtn=new JButton("Clear");
        JButton exitBtn=new JButton("Exit");

        buttons.add(addBtn);
        buttons.add(updateBtn);
        buttons.add(deleteBtn);
        buttons.add(searchBtn);
        buttons.add(clearBtn);
        buttons.add(exitBtn);

        add(buttons,BorderLayout.SOUTH);

        addBtn.addActionListener(e->{
            try{
                Student s=new Student(
                        txtId.getText().trim(),
                        txtName.getText().trim(),
                        Integer.parseInt(txtAge.getText().trim()),
                        txtDepartment.getText().trim(),
                        Double.parseDouble(txtGpa.getText().replace(",","."))
                );

                if(manager.addStudent(s)){
                    refreshTable();
                    clearFields();
                    JOptionPane.showMessageDialog(this,"Student added.");
                }else{
                    JOptionPane.showMessageDialog(this,"ID already exists.");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid input.");
            }
        });

        updateBtn.addActionListener(e->{
            try{
                boolean ok=manager.updateStudent(
                        txtId.getText().trim(),
                        txtName.getText().trim(),
                        Integer.parseInt(txtAge.getText().trim()),
                        txtDepartment.getText().trim(),
                        Double.parseDouble(txtGpa.getText().replace(",","."))
                );
                if(ok){
                    refreshTable();
                    JOptionPane.showMessageDialog(this,"Student updated.");
                }else{
                    JOptionPane.showMessageDialog(this,"Student not found.");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid input.");
            }
        });

        deleteBtn.addActionListener(e->{
            if(manager.deleteStudent(txtId.getText().trim())){
                refreshTable();
                clearFields();
                JOptionPane.showMessageDialog(this,"Student deleted.");
            }else{
                JOptionPane.showMessageDialog(this,"Student not found.");
            }
        });

        searchBtn.addActionListener(e->{
            Student s=manager.searchStudent(txtId.getText().trim());
            if(s==null){
                JOptionPane.showMessageDialog(this,"Student not found.");
                return;
            }
            txtName.setText(s.getName());
            txtAge.setText(String.valueOf(s.getAge()));
            txtDepartment.setText(s.getDepartment());
            txtGpa.setText(String.valueOf(s.getGpa()));
        });

        clearBtn.addActionListener(e->clearFields());
        exitBtn.addActionListener(e->dispose());

        table.getSelectionModel().addListSelectionListener(e->{
            if(table.getSelectedRow()<0)return;
            txtId.setText(model.getValueAt(table.getSelectedRow(),0).toString());
            txtName.setText(model.getValueAt(table.getSelectedRow(),1).toString());
            txtAge.setText(model.getValueAt(table.getSelectedRow(),2).toString());
            txtDepartment.setText(model.getValueAt(table.getSelectedRow(),3).toString());
            txtGpa.setText(model.getValueAt(table.getSelectedRow(),4).toString());
        });

        setVisible(true);
    }

    private void refreshTable(){
        model.setRowCount(0);
        for(Student s: manager.getStudents()){
            model.addRow(new Object[]{
                s.getId(),s.getName(),s.getAge(),
                s.getDepartment(),
                String.format("%.2f",s.getGpa())
            });
        }
    }

    private void clearFields(){
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtDepartment.setText("");
        txtGpa.setText("");
    }
}
