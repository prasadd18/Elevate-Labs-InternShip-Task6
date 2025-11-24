import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
class ToDoApp
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("TO DO APP");
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JTextField taskField=new JTextField();
		frame.add(taskField,BorderLayout.NORTH);
		DefaultListModel<String> listModel=new DefaultListModel<>();
		JList taskList=new JList(listModel);
		frame.add(new JScrollPane(taskList),BorderLayout.CENTER);
		JPanel buttonPanel=new JPanel();
		JButton addBtn=new JButton("ADD");
		JButton deleteBtn=new JButton("DELETE");
		buttonPanel.add(addBtn);
		buttonPanel.add(deleteBtn);
		frame.add(buttonPanel,BorderLayout.SOUTH);
		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String task=taskField.getText();
				if(!task.isEmpty())
				{
					listModel.addElement(task);
					taskField.setText("");
					
				}
			}
		});
		deleteBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int index=taskList.getSelectedIndex();
				if(index!=-1)
				{
					listModel.remove(index);
				}
			}
		});
		frame.setVisible(true);
	}

}
