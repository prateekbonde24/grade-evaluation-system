package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBException;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.List;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class Ui extends JFrame {

	private JPanel contentPane;
	private JTextField student_id;
	private JTextField grade;
	private JTextField newgradeitem;
	private JButton btnSubmit;
	private JLabel lblStudentId;
	private JComboBox gradeItem;
	private JRadioButton create;
	private JLabel labelcodeoutput;
	private JLabel output2;
	private JRadioButton read;

	private JRadioButton update;
	private ButtonGroup crud;
	private JRadioButton delete;
	private URI resourceURI;
	HashMap<String, String> gradeitemlist;
	ArrayList<String> mygradeitems;
	private JTextField feedback;
	private JLabel lblUri;
	private JLabel URI;
	private JPanel gradeitempanel;
	private JLabel note;
	private JLabel lblNote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui frame = new Ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void clear(){
		student_id.setText("");
		grade.setText("");
		newgradeitem.setText("");
		feedback.setText("");
	}
	public Ui() {
		ClientConfig config = new ClientConfig();
		Client client = (Client) ClientBuilder.newClient(config);
		final WebTarget webtarget = client.target(UriBuilder.fromUri("http://localhost:8080/").build());

		lblNote = new JLabel("Note:");
		lblNote.setForeground(new Color(255, 0, 0));
		lblNote.setVisible(false);
		gradeitemlist = new HashMap<String, String>();
		mygradeitems = new ArrayList<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblGradebook = new JLabel("Gradebook");

		JPanel panel = new JPanel();

		create = new JRadioButton("Create");

		read = new JRadioButton("Read");

		update = new JRadioButton("Update");

		delete = new JRadioButton("Delete");
		crud = new ButtonGroup();
		crud.add(create);
		crud.add(read);
		crud.add(update);
		crud.add(delete);
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (read.isSelected()) {

					// grade.setEditable(false);
					// feedback.setEditable(false);
					 grade.setEnabled(false);
					 feedback.setEnabled(false);
					btnSubmit.setVisible(true);
					lblNote.setVisible(false);
					btnSubmit.setText("Read");
				}

			}
		});
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (create.isSelected()) {

					grade.setEditable(true);
					feedback.setEditable(true);
					grade.setEnabled(true);
					feedback.setEnabled(true);
					btnSubmit.setVisible(true);
					btnSubmit.setText("Create");
					lblNote.setVisible(false);
				}

			}
		});
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (update.isSelected()) {

					grade.setEditable(true);
					feedback.setEditable(true);
					grade.setEnabled(true);
					feedback.setEnabled(true);
					btnSubmit.setVisible(true);
					btnSubmit.setText("Update");
					lblNote.setVisible(false);
				}

			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (delete.isSelected()) {

					// grade.setEditable(false);
					// feedback.setEditable(false);
					grade.setEnabled(false);
					feedback.setEnabled(false);
					btnSubmit.setVisible(true);
					btnSubmit.setText("Delete");
					// JOptionPane.show
					lblNote.setVisible(true);
					lblNote.setText(
							"NOTE : Enter both studentid and gradeitem to delete grade of a particular student. To delete for all students just select gradeitem");
				}

			}
		});

		JPanel panel_1 = new JPanel();

		note = new JLabel("");
		note.setLabelFor(delete);
		note.setForeground(new Color(255, 0, 0));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(create).addGap(5).addComponent(read)
						.addGap(5).addComponent(update).addGap(5).addComponent(delete)
						.addContainerGap(398, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(note, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(panel_1,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNote).addContainerGap(590,
						Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(create)
								.addComponent(read).addComponent(update).addComponent(delete))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(note)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNote).addGap(4)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));

		student_id = new JTextField();
		student_id.setColumns(10);

		grade = new JTextField();
		grade.setColumns(10);

		btnSubmit = new JButton("Submit");
		btnSubmit.setVisible(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (create.isSelected()) {

					if (!grade.getText().isEmpty()) {
						String studentid, gradeitem, marks, feedback;
						studentid = student_id.getText().trim();
						// System.out.println(studentid);
						gradeitem = gradeItem.getSelectedItem().toString().trim();
						marks = grade.getText().trim();
						feedback = Ui.this.feedback.getText().trim();
						if (!marks.isEmpty() && !studentid.isEmpty() && !gradeitem.isEmpty()) {
							JSONObject obj = new JSONObject();
							obj.put("student_id", studentid);
							obj.put("grade_item", gradeitem);
							obj.put("marks", marks);
							obj.put("feedback", feedback);

							Response r = webtarget.path("CRUD-Gradebook-psbonde-eclipse-server").path("GradeBook")
									.path("create").request().post(Entity.json(obj.toString()), Response.class);
							if (r.getStatus() == Response.Status.CREATED.getStatusCode()) {
								labelcodeoutput.setText(String.valueOf(r.getStatus()));
								output2.setText(String.valueOf(r.readEntity(String.class)));
								JOptionPane.showMessageDialog(null, "Grade added for student " + studentid
										+ " for gradeitem " + gradeitem + " with feedback " + feedback);
								URI.setText(String.valueOf(r.getLocation()));
								clear();
								
							} else {
								labelcodeoutput.setText(String.valueOf(r.getStatus()));
								output2.setText(String.valueOf(r.readEntity(String.class)));
							}

						}

						else {
							JOptionPane.showMessageDialog(null, "Please enter valid input");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please enter valid input");
					}
				} else if (delete.isSelected()) {
					int a = -1, b = -1;
					String gradeitem;
					String studentid;
					gradeitem = gradeItem.getSelectedItem().toString().trim();
					studentid = student_id.getText().trim();
					if (studentid.isEmpty() && !gradeitem.isEmpty()) {
						a = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete gradeitem " + gradeitem + "?", "Confirmation?",
								JOptionPane.YES_NO_OPTION);
						// lblNote.setText(Integer.toString(a));
					} else if ((gradeitem.isEmpty() && !studentid.isEmpty())
							|| (gradeitem.isEmpty() && studentid.isEmpty())) {
						JOptionPane.showConfirmDialog(null, "Please enter gradeitem to be deleted", "Request",
								JOptionPane.OK_OPTION);

					} else {
						b = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete student" + studentid + " grade for " + gradeitem + "?",
								"Confirmation?", JOptionPane.YES_NO_OPTION);
					}

					if (a == 0) {
						// lblNote.setText("deleted dude");
						Response r = webtarget.path("CRUD-Gradebook-psbonde-eclipse-server").path("GradeBook")
								.path("gradeitem").path(gradeitem).request().delete();
						if (r.getStatus() == 204) {
							mygradeitems.remove(gradeItem.getSelectedItem().toString());
							gradeItem.setModel(new DefaultComboBoxModel<>(mygradeitems.toArray()));
							labelcodeoutput.setText(String.valueOf(r.getStatus()));
							output2.setText(String.valueOf(r.readEntity(String.class)));
							URI.setText(String.valueOf(r.getLocation()));
						
							JOptionPane.showMessageDialog(null, "Deleted gradeitem " + gradeitem);
							clear();
						} else {
							labelcodeoutput.setText(String.valueOf(r.getStatus()));
							output2.setText(String.valueOf(r.readEntity(String.class)));

						}

					} else if (b == 0) {
						Response r = webtarget.path("CRUD-Gradebook-psbonde-eclipse-server").path("GradeBook")
								.path("gradeitem").path(gradeitem).path("studentid").path(studentid).request().delete();
						if (r.getStatus() == 204) {

							labelcodeoutput.setText(String.valueOf(r.getStatus()));
							output2.setText(String.valueOf(r.readEntity(String.class)));
							URI.setText(String.valueOf(r.getLocation()));
							
							JOptionPane.showMessageDialog(null,
									"Deleted marks for student" + studentid + " for gradeitem " + gradeitem);
							clear();
						} else {
							labelcodeoutput.setText(String.valueOf(r.getStatus()));
							output2.setText(String.valueOf(r.readEntity(String.class)));

						}
					}
					// lblNote.setText(Integer.toString(a));
				} else if (update.isSelected()) {
					String studentid, gradeitem, marks, feedback;
					studentid = student_id.getText().trim();
					// System.out.println(studentid);
					gradeitem = gradeItem.getSelectedItem().toString().trim();
					marks = grade.getText().trim();
					feedback = Ui.this.feedback.getText().trim();
					if (!marks.isEmpty() || !studentid.isEmpty() || !gradeitem.isEmpty()) {
						JSONObject obj = new JSONObject();
						obj.put("student_id", studentid);
						obj.put("grade_item", gradeitem);
						obj.put("marks", marks);
						obj.put("feedback", feedback);

						Response r = webtarget.path("CRUD-Gradebook-psbonde-eclipse-server").path("GradeBook")
								.path("gradeitem").path(gradeitem).path("studentid").path(studentid).request()
								.put(Entity.json(obj.toString()), Response.class);
						labelcodeoutput.setText(String.valueOf(r.getStatus()));
						
						output2.setText(String.valueOf(r.readEntity(String.class)));

						URI.setText(String.valueOf(r.getLocation()));
						JOptionPane.showMessageDialog(null, "Updated");
						clear();
					} else {
						labelcodeoutput.setText("Invalid Input");
						output2.setText("same as above");
					}
				} else if (read.isSelected()) {
					String gradeitem;
					String studentid;
					gradeitem = gradeItem.getSelectedItem().toString().trim();
					studentid = student_id.getText().trim();

					if (!gradeitem.isEmpty() && !studentid.isEmpty()) {

						Response r = webtarget.path("CRUD-Gradebook-psbonde-eclipse-server").path("GradeBook")
								.path("gradeitem").path(gradeitem).path("studentid").path(studentid).request()
								.get(Response.class);
						System.out.println(r.getStatus());
						if (r.getStatus() == Response.Status.OK.getStatusCode()) {
							// System.out.println("here1");
							String item = String.valueOf(r.readEntity(String.class));
							// System.out.println(item);
							// note.setText(item);
							JSONObject myobject = new JSONObject(item);
							String studentid1, gradeitem1, marks, feedback;
							studentid1 = myobject.getString("student_id");
							gradeitem1 = myobject.getString("grade_item");
							marks = myobject.getString("marks");
							feedback = myobject.getString("feedback");
							student_id.setText(studentid1);
							grade.setText(marks);
							Ui.this.feedback.setText(feedback);
							labelcodeoutput.setText(String.valueOf(r.getStatus()));
							// output2.setText(String.valueOf(r.readEntity(String.class)));
							 URI.setText(String.valueOf(r.getLocation()));
							JOptionPane.showMessageDialog(null, "Data Read");
						} else {
							labelcodeoutput.setText(String.valueOf(r.getStatus()));
							output2.setText(String.valueOf(r.readEntity(String.class)));
							// URI.setText(String.valueOf(r.getLocation()));
						}

					}

					else {
						JOptionPane.showMessageDialog(null, "Please check input");

					}

				}

			}

		});

		lblStudentId = new JLabel("Student id");

		JLabel lblNewLabel = new JLabel("Grade Item");

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(new Color(255, 255, 255));

		JLabel lblGrade = new JLabel("Grade");

		gradeItem = new JComboBox();

		JPanel panel_2 = new JPanel();

		feedback = new JTextField();
		feedback.setColumns(10);

		JLabel lblFeedback = new JLabel("Feedback");

		JLabel lblCode = new JLabel("Code:");

		labelcodeoutput = new JLabel("");

		JLabel lblNewLabel_1 = new JLabel("Message : ");

		output2 = new JLabel("");

		lblUri = new JLabel("URI :");

		URI = new JLabel("");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(output2, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblCode)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelcodeoutput))
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblUri)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(URI)))
						.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblCode).addComponent(
								labelcodeoutput))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(output2, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel_1).addGap(18)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblUri).addComponent(URI))))
						.addContainerGap(62, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		gradeitempanel = new JPanel();

		JLabel lblNewGradeItme = new JLabel("New Grade Item");

		newgradeitem = new JTextField();
		newgradeitem.setColumns(10);

		JButton add = new JButton("Add");
		GroupLayout gl_gradeitempanel = new GroupLayout(gradeitempanel);
		gl_gradeitempanel.setHorizontalGroup(gl_gradeitempanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradeitempanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_gradeitempanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(add, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(newgradeitem, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewGradeItme, GroupLayout.PREFERRED_SIZE, 138,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(48, Short.MAX_VALUE)));
		gl_gradeitempanel.setVerticalGroup(gl_gradeitempanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gradeitempanel.createSequentialGroup().addGap(6).addComponent(lblNewGradeItme)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(newgradeitem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(add, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE).addContainerGap()));
		gradeitempanel.setLayout(gl_gradeitempanel);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// gradeitemlist.put(newgradeitem.getText(),
				// newgradeitem.getText());
				// mygradeitems=new ArrayList<String>(gradeitemlist.values());

				String item = "{'grade_item': " + newgradeitem.getText() + "}";
				Response r = webtarget.path("CRUD-Gradebook-psbonde-eclipse-server").path("GradeBook")
						.path("creategradeitem").request().post(Entity.json(item), Response.class);
				if (r.getStatus() == 201) {
					mygradeitems.add(newgradeitem.getText());
					gradeItem.setModel(new DefaultComboBoxModel<>(mygradeitems.toArray()));
					JOptionPane.showMessageDialog(null, "Added");
					labelcodeoutput.setText(String.valueOf(r.getStatus()));
					output2.setText(String.valueOf(r.readEntity(String.class)));
					newgradeitem.setText("");

				} else {
					labelcodeoutput.setText(String.valueOf(r.getStatus()));
					output2.setText(String.valueOf(r.readEntity(String.class)));
				}

			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(grade, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFeedback)
								.addComponent(feedback, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(652, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblGrade)
								.addComponent(lblStudentId))
							.addPreferredGap(ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(list)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(gradeitempanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(176))))))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(gradeItem, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(652, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(student_id, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(652, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addGap(247))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(67)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(727, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(gradeitempanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(list)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblStudentId)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(student_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblGrade)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(grade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFeedback)
					.addGap(6)
					.addComponent(feedback, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGradebook, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblGradebook)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
