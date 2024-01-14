import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OnlineTest extends JFrame implements ActionListener {

	JLabel l, nameLabel, classLabel;
	JTextField nameTextField, classTextField;
	JRadioButton jb[] = new JRadioButton[5];
	JButton b1, b2;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	JTextArea notepad;

	OnlineTest(String s) {
		super(s);

		// Set warna background menjadi aquamarine
		getContentPane().setBackground(new Color(127, 255, 212));

		l = new JLabel();
		add(l);

		nameLabel = new JLabel("Nama:");
		nameLabel.setBounds(30, 10, 50, 20);
		add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(80, 10, 150, 20);
		add(nameTextField);

		classLabel = new JLabel("Kelas:");
		classLabel.setBounds(250, 10, 50, 20);
		add(classLabel);

		classTextField = new JTextField();
		classTextField.setBounds(300, 10, 150, 20);
		add(classTextField);

		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			jb[i] = new JRadioButton();
			// Set warna pilihan jawaban menjadi aquamarine
			jb[i].setBackground(new Color(127, 255, 212));
			add(jb[i]);
			bg.add(jb[i]);
		}

		b1 = new JButton("Next");
		b2 = new JButton("Bookmark");

		// Set warna tombol Next dan Bookmark menjadi cream
		b1.setBackground(new Color(255, 253, 208));
		b2.setBackground(new Color(255, 253, 208));

		b1.addActionListener(this);
		b2.addActionListener(this);

		add(b1);
		add(b2);

		notepad = new JTextArea();
		notepad.setBounds(300, 70, 80, 160);
		add(notepad);

		set();
		l.setBounds(30, 40, 350, 20);

		for (int i = 0; i < 5; i++) {
			jb[i].setBounds(50, 80 + 30 * i, 200, 20);
		}

		b1.setBounds(100, 240, 100, 30);
		b2.setBounds(270, 240, 100, 30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			// Set warna tombol bookmark yang di-generate dinamis menjadi cream
			bk.setBackground(new Color(255, 253, 208));
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;

			// Tambahkan hasil jawaban, nama, dan kelas ke notepad
			String resultText = "Nama: " + nameTextField.getText() +
					"\nKelas: " + classTextField.getText() +
					"\nPoin: " + count;
			notepad.setText(resultText);
			current++;
		}
	}

	void set() {
		jb[4].setSelected(true);
		if (current == 0) {
			l.setText("Q1: Hitunglah hasil penjumlahan 8 + 4 =");
			jb[0].setText("10");
			jb[1].setText("12");
			jb[2].setText("9");
			jb[3].setText("14");
		}
		if (current == 1) {
			l.setText("Q2: Ada 7 apel di keranjang ditambah 3 apel, berapa jumlahnya?");
			jb[0].setText("5");
			jb[1].setText("16");
			jb[2].setText("10");
			jb[3].setText("9");
		}
		if (current == 2) {
			l.setText("Q3: Kurangkan 9 dengan 15");
			jb[0].setText("9");
			jb[1].setText("8");
			jb[2].setText("6");
			jb[3].setText("-6");
		}
		if (current == 3) {
			l.setText("Q4: Sebuah kelas memiliki 20 murid dan 5 murid tidak masuk, berapa jumlahnya?");
			jb[0].setText("15");
			jb[1].setText("10");
			jb[2].setText("4");
			jb[3].setText("25");
		}
		if (current == 4) {
			l.setText("Q5: Hitunglah hasil perkalian 6 x 2");
			jb[0].setText("10");
			jb[1].setText("11");
			jb[2].setText("12");
			jb[3].setText("13");
		}
		if (current == 5) {
			l.setText("Q6: Sebuah kotak berisi 9 kelereng. Jika 4 kelereng diambil, berapa sisanya?");
			jb[0].setText("4");
			jb[1].setText("9");
			jb[2].setText("5");
			jb[3].setText("6");
		}
		if (current == 6) {
			l.setText("Q7: Sebuah buku memiliki 25 halaman dan kita membaca 8 halaman, berapa sisanya?");
			jb[0].setText("18");
			jb[1].setText("17");
			jb[2].setText("16");
			jb[3].setText("15");
		}
		if (current == 7) {
			l.setText("Q8: Hitunglah hasil pembagian 18 ÷ 3");
			jb[0].setText("12");
			jb[1].setText("10");
			jb[2].setText("8");
			jb[3].setText("6");
		}
		if (current == 8) {
			l.setText("Q9: 12-10+5=");
			jb[0].setText("8");
			jb[1].setText("7");
			jb[2].setText("6");
			jb[3].setText("5");
		}
		if (current == 9) {
			l.setText("Q10: 2x4-5=");
			jb[0].setText("5");
			jb[1].setText("4");
			jb[2].setText("3");
			jb[3].setText("2");
		}
		l.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			jb[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (jb[1].isSelected());
		if (current == 1)
			return (jb[2].isSelected());
		if (current == 2)
			return (jb[3].isSelected());
		if (current == 3)
			return (jb[0].isSelected());
		if (current == 4)
			return (jb[2].isSelected());
		if (current == 5)
			return (jb[2].isSelected());
		if (current == 6)
			return (jb[1].isSelected());
		if (current == 7)
			return (jb[3].isSelected());
		if (current == 8)
			return (jb[1].isSelected());
		if (current == 9)
			return (jb[2].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("UJIAN MATEMATIKA : KELAS 1 SD NUSA BANGSA");
	}
}
