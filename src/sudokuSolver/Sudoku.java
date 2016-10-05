/***
 * This class is completely taken from a StackOverflow comment : http://stackoverflow.com/a/12888426
 */

package sudokuSolver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;

public class Sudoku {

    public Sudoku() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new SudokuBoard());
                frame.add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
                frame.pack();
                frame.setTitle("Sudoku Solver");
                frame.setSize(400, 325);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MenuPane extends JPanel implements ActionListener {
    	JButton solveButton = new JButton("Solve");
        JButton resetButton = new JButton("Reset");
        
        public MenuPane() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(solveButton, gbc);
            gbc.gridy++;
            add(resetButton, gbc);
            
            solveButton.addActionListener(this);
            resetButton.addActionListener(this);
        }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == solveButton)
			    System.out.println("Vous avez cliqué sur le bouton solve");
	  
			if(e.getSource() == resetButton)
				System.out.println("Vous avez cliqué sur le bouton reset");
		}
    }

    public class SudokuBoard extends JPanel {

        public static final int GRID_ROWS = 1;
        public static final int GRID_COLUMNS = 1;
        public static final int BOARD_ROWS = 9;
        public static final int BOARD_COLUMNS = 9;
        private JTextField fields[][];

        public SudokuBoard() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            fields = new JTextField[GRID_ROWS * BOARD_ROWS][GRID_COLUMNS * BOARD_COLUMNS];
            
            setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS, 2, 2));
            for (int row = 0; row < GRID_ROWS; row++) {
                for (int col = 0; col < GRID_COLUMNS; col++) {
                    int startRow = row * GRID_ROWS;
                    int startCol = col * GRID_COLUMNS;
                    add(createBoard(fields, startRow, startCol));
                }
            }
            
            PatternFilter filter = new PatternFilter("[1-9]");
            AbstractDocument doc;
            
            for (int i = 0; i < 9; i++) {
            	for (int j = 0; j < 9; j++) {
            		doc = (AbstractDocument) fields[i][j].getDocument();
                    doc.setDocumentFilter(filter);
                }
            }
        }

        protected JPanel createBoard(JTextField fiels[][], int startRow, int startCol) {
            JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
            panel.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY, 2), new EmptyBorder(2, 2, 2, 2)));

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int rowIndex = (startRow + row) * 3;
                    int colIndex = (startCol + col) * 3;
                    panel.add(createSubBoard(fields, rowIndex, colIndex));
                }
            }
            return panel;
        }

        protected JPanel createSubBoard(JTextField[][] fields, int startRow, int startCol) {
            JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
            panel.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 2), new EmptyBorder(2, 2, 2, 2)));

            populateFields(fields, startRow, startCol);
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    panel.add(fields[row + startRow][col + startCol]);
                }
            }
            return panel;
        }

        protected void populateFields(JTextField[][] fields, int startRow, int startCol) {
            for (int row = startRow; row < startRow + 3; row++) {
                for (int col = startCol; col < startCol + 3; col++) {
                    fields[row][col] = new JTextField(4);
                }
            }
        }
    }
}