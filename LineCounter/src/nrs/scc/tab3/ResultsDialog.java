/*
 *  SourceCodeCounter
 *  Copyright (C) 2009 Nick Sydenham <nsydenham@yahoo.co.uk>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nrs.scc.tab3;

import java.awt.Frame;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;

/**
 * Displays the results of the file count
 *
 * @author Copyright 2009 Nick Sydenham &lt;nsydenham@yahoo.co.uk&gt;
 */
public class ResultsDialog extends JDialog
{
	private class ErrorTableModel extends DefaultTableModel
	{
		@Override
		public Class<?> getColumnClass(int columnIndex)
		{
			return String.class;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column)
		{
			// no-op to prevent accidental edits
		}
	}

	private DefaultTableModel dtm = new ErrorTableModel();

    /** Creates new form ResultsDialog */
    public ResultsDialog(Frame parent)
	{
        super(parent, true);
        initComponents();
		getRootPane().setDefaultButton(closeButton);
		errorsScroll.setVisible(false);

		ResourceMap resourceMap = Application.getInstance(nrs.scc.SourceCodeCounter.class).getContext().getResourceMap(ResultsDialog.class);
		dtm.addColumn(resourceMap.getString("fileName"));
		dtm.addColumn(resourceMap.getString("error"));

		errorsTable.setModel(dtm);
    }

	/**
	 * Create a new ResultsDialog
	 * @param parent
	 * @param filesCounted
	 * @param timeTaken formatted time taken
	 * @param threads
	 * @param msgsSec formatted msgs/sec
	 * @param errors
	 */
	public ResultsDialog(Frame parent, int filesCounted, String timeTaken, int threads, String msgsSec, Map<String, String> errors)
	{
		this(parent);

		filesCountedTF.setText(Integer.toString(filesCounted));
		threadsTF.setText(Integer.toString(threads));
		timeTF.setText(timeTaken);
		filesSecTF.setText(msgsSec);

		if (!errors.isEmpty())
		{
			errorsScroll.setVisible(true);
			Object[] rowData = new Object[2];
			for (Map.Entry<String, String> entry : errors.entrySet())
			{
				rowData[0] = entry.getKey();
				rowData[1] = entry.getValue();
				dtm.addRow(rowData);
			}
		}
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resultsLabel = new javax.swing.JLabel();
        filesCountedLabel = new javax.swing.JLabel();
        filesCountedTF = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        timeTF = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();
        threadsLabel = new javax.swing.JLabel();
        threadsTF = new javax.swing.JTextField();
        filesSec = new javax.swing.JLabel();
        filesSecTF = new javax.swing.JTextField();
        errorsScroll = new javax.swing.JScrollPane();
        errorsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(nrs.scc.SourceCodeCounter.class).getContext().getResourceMap(ResultsDialog.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        resultsLabel.setFont(resultsLabel.getFont().deriveFont(resultsLabel.getFont().getStyle() | java.awt.Font.BOLD, resultsLabel.getFont().getSize()+8));
        resultsLabel.setForeground(resourceMap.getColor("resultsLabel.foreground")); // NOI18N
        resultsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultsLabel.setText(resourceMap.getString("resultsLabel.text")); // NOI18N
        resultsLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        resultsLabel.setName("resultsLabel"); // NOI18N

        filesCountedLabel.setDisplayedMnemonic('F');
        filesCountedLabel.setLabelFor(filesCountedTF);
        filesCountedLabel.setText(resourceMap.getString("filesCountedLabel.text")); // NOI18N
        filesCountedLabel.setName("filesCountedLabel"); // NOI18N

        filesCountedTF.setColumns(5);
        filesCountedTF.setEditable(false);
        filesCountedTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filesCountedTF.setText(resourceMap.getString("filesCountedTF.text")); // NOI18N
        filesCountedTF.setName("filesCountedTF"); // NOI18N

        timeLabel.setDisplayedMnemonic('T');
        timeLabel.setLabelFor(timeTF);
        timeLabel.setText(resourceMap.getString("timeLabel.text")); // NOI18N
        timeLabel.setName("timeLabel"); // NOI18N

        timeTF.setColumns(8);
        timeTF.setEditable(false);
        timeTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timeTF.setText(resourceMap.getString("timeTF.text")); // NOI18N
        timeTF.setName("timeTF"); // NOI18N

        closeButton.setMnemonic('C');
        closeButton.setText(resourceMap.getString("closeButton.text")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeDialog(evt);
            }
        });

        threadsLabel.setText(resourceMap.getString("threadsLabel.text")); // NOI18N
        threadsLabel.setName("threadsLabel"); // NOI18N

        threadsTF.setColumns(5);
        threadsTF.setEditable(false);
        threadsTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        threadsTF.setText(resourceMap.getString("threadsTF.text")); // NOI18N
        threadsTF.setName("threadsTF"); // NOI18N

        filesSec.setText(resourceMap.getString("filesSec.text")); // NOI18N
        filesSec.setName("filesSec"); // NOI18N

        filesSecTF.setColumns(8);
        filesSecTF.setEditable(false);
        filesSecTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filesSecTF.setText(resourceMap.getString("filesSecTF.text")); // NOI18N
        filesSecTF.setName("filesSecTF"); // NOI18N

        errorsScroll.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("errorsScroll.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)); // NOI18N
        errorsScroll.setName("errorsScroll"); // NOI18N

        errorsTable.setName("errorsTable"); // NOI18N
        errorsTable.getTableHeader().setReorderingAllowed(false);
        errorsScroll.setViewportView(errorsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(resultsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filesCountedLabel)
                            .addComponent(threadsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filesCountedTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(threadsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filesSec)
                            .addComponent(timeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filesSecTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(closeButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filesCountedLabel)
                    .addComponent(filesCountedTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel)
                    .addComponent(timeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threadsLabel)
                    .addComponent(threadsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filesSec)
                    .addComponent(filesSecTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorsScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void closeDialog(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeDialog
	{//GEN-HEADEREND:event_closeDialog
		dispose();
}//GEN-LAST:event_closeDialog

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ResultsDialog dialog = new ResultsDialog(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane errorsScroll;
    private javax.swing.JTable errorsTable;
    private javax.swing.JLabel filesCountedLabel;
    private javax.swing.JTextField filesCountedTF;
    private javax.swing.JLabel filesSec;
    private javax.swing.JTextField filesSecTF;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.JLabel threadsLabel;
    private javax.swing.JTextField threadsTF;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTF;
    // End of variables declaration//GEN-END:variables

}
