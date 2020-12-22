import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

class Item implements Serializable{ // Item Ŭ����
	String headline; int points;
	public Item(String headline, int points) {
		this.headline = headline; 
		this.points = points;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
class Movie extends Item implements Serializable{ // Movie Ŭ����
	String movie_director, movie_actor, movie_ganre, movie_level, movie_open, movie_poster, movie_plot, movie_review;
	public Movie(String movie_title, String movie_director, String movie_actor, String movie_ganre, 
			String movie_level, String movie_open, String movie_poster, int movie_score, String movie_plot, String movie_review) {
		super(movie_title, movie_score);
		this.movie_director = movie_director;
		this.movie_actor = movie_actor;
		this.movie_ganre = movie_ganre;
		this.movie_level = movie_level;
		this.movie_open = movie_open;
		this.movie_poster = movie_poster;
		this.movie_plot = movie_plot;
		this.movie_review = movie_review;
	}
	public String getMovie_director() {
		return movie_director;
	}
	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}
	public String getMovie_actor() {
		return movie_actor;
	}
	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}
	public String getMovie_ganre() {
		return movie_ganre;
	}
	public void setMovie_ganre(String movie_ganre) {
		this.movie_ganre = movie_ganre;
	}
	public String getMovie_level() {
		return movie_level;
	}
	public void setMovie_level(String movie_level) {
		this.movie_level = movie_level;
	}
	public String getMovie_open() {
		return movie_open;
	}
	public void setMovie_open(String movie_open) {
		this.movie_open = movie_open;
	}
	public String getMovie_poster() {
		return movie_poster;
	}
	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}
	public String getMovie_plot() {
		return movie_plot;
	}
	public void setMovie_plot(String movie_plot) {
		this.movie_plot = movie_plot;
	}
	public String getMovie_review() {
		return movie_review;
	}
	public void setMovie_review(String movie_review) {
		this.movie_review = movie_review;
	}
}
class Book extends Item implements Serializable{ // Book Ŭ����
	String book_author, book_pub, book_year, book_image, book_plot, book_review;
	public Book(String book_title, String book_author, String book_pub, String book_year, 
			String book_image, int book_score, String book_plot, String book_review) {
		super(book_title, book_score);
		this.book_author = book_author;
		this.book_pub = book_pub;
		this.book_year = book_year;
		this.book_image = book_image;
		this.book_plot = book_plot;
		this.book_review = book_review;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_pub() {
		return book_pub;
	}
	public void setBook_pub(String book_pub) {
		this.book_pub = book_pub;
	}
	public String getBook_year() {
		return book_year;
	}
	public void setBook_year(String book_year) {
		this.book_year = book_year;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getBook_plot() {
		return book_plot;
	}
	public void setBook_plot(String book_plot) {
		this.book_plot = book_plot;
	}
	public String getBook_review() {
		return book_review;
	}
	public void setBook_review(String book_review) {
		this.book_review = book_review;
	}
}   
public class LabFinalProject extends JFrame{
	// ������� ����
	Vector<Item> item = new Vector<>();
	Vector<Movie> movie = new Vector<>();
	Vector<Book> book = new Vector<>();
	JButton btn1, btn2, btn3, btnsearch;
	JTextArea ja1, ja2, plot_area, review_area, intro_area, re_area;
	JPanel panel = new MyPanel();
	JRadioButton rb1, rb2;
	JLabel title, director, actor, ganre, level, open, poster, score_movie, plot, review, title_book, author, pub, year, image, time, 
	score_book, intro, re;
	JButton poster_but, ok, image_but, ok_b;
	JTextField title_area, dir_area, actor_area, poster_area, title_book_area, author_area, pub_area, image_area, jfsearch;
	JSlider slider_movie, slider_book;
	JTabbedPane pane;
	Container cp;
	JPanel panel1, panel2, searchp;
	Vector<String> v = new Vector<String>();
	JList<String> vList = new JList<String>(v);
	Vector<String> v_movie = new Vector<String>();
	JList<String> vList_movie = new JList<String>(v_movie);
	Vector<String> v_book = new Vector<String>();
	JList<String> vList_book = new JList<String>(v_book);
	Vector<String> v_search = new Vector<String>();
	JList<String> vList_search = new JList<String>(v_search);
	Container c = getContentPane();
	ItemCollections collections = new ItemCollections();
	String changewhat;
	private String[] ganre_vec = {"���", "�ڹ̵�", "�׼�", "��Ÿ��", "�θǽ�"};
	private String[] level_vec = {"��ü", "12�� �̻�", "15�� �̻�", "û�ҳ� ���� �Ұ�"};
	private String[] open_vec = {"2000","2001","2002","2003","2004","2005","2006","2007","2008",
			"2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	String[] search_vec = {"����", "����"};
	JComboBox<String> ganre_Combo, level_Combo, open_Combo, year_Combo, search_Combo;
	JLabel t, a, p, y, poi, t1, a1, p1, y1, poi1, imageno, tm, am, pm, ym, poim, gm, lm, tm1, am1, pm1, ym1, poim1, gm1, lm1;
	ImageIcon icon; JLabel imageLabel;
	JScrollPane scroll3, scroll4, scroll5, scroll6;
	int count=1;
	public LabFinalProject() { // ù ȭ��
		setTitle("JAVA 005�й� 1611888 ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu(); c.setLayout(null);
		time = new MyLabel();
		time.setFont(new Font("���", Font.ITALIC, 20));
		time.setBounds(600, 12, 500, 50); c.add(time);
		JLabel label = new JLabel("My Notes");
		label.setOpaque(true); 
		label.setForeground(new Color(0,0,153));
		label.setFont(new Font("���", Font.ITALIC | Font.BOLD, 40));
		label.setLocation(150, 10);
		label.setSize(200, 40); c.add(label);
		vList.addMouseListener(new MouseAdapter1());
		vList_movie.addMouseListener(new MouseAdapter2());
		vList_book.addMouseListener(new MouseAdapter3());
		vList_search.addMouseListener(new MouseAdapter4());
		btn1 = new JButton("�߰�"); // �߰� ��ư�� ������ newWindow() ����, ���� �� ��ȭ ������ �Է��� �� �ִ� â�� ��.
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new newWindow();
			}
		});
		btn1.setLocation(110, 690); btn1.setSize(60, 30); c.add(btn1);
		btn2 = new JButton("����"); btn2.setLocation(540, 690); btn2.setSize(60, 30); c.add(btn2);
		// ���� ��ư�� ������ �Է� ��Ŀ� ���õ� �׸��� ���� ������� �������, ������ ���� �Է��ϰ� ok�� ������ �ش� �׸��� ������ �����ϰ� �� ����� ������
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
				collections.changeItem();
			}
		});
		btn3 = new JButton("����"); btn3.setLocation(620, 690); btn3.setSize(60, 30); c.add(btn3);
		// ���� ��ư�� ������ ���� Ȯ�� �޽����� �����
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result =  JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_OPTION);
				// "��"�� ������ �ش� �׸��� �÷��ǿ��� �����ϰ� ����� ����� �ٽ� ������
				if(result == JOptionPane.YES_OPTION)
					collections.deleteItem();
			}
		});
		// TabbedPane ����, �Ʒ��� �� ù ȭ�� ui
		pane = createTabbedPane();
		pane.setLocation(5, 55);
		pane.setSize(280, 620);
		c.add(pane);
		JPanel pl1 = new JPanel();
		pl1.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"�� ����"));
		pl1.setLocation(300, 58);
		pl1.setSize(660, 620);
		pl1.setLayout(null);
		JPanel pl2 = new JPanel();
		pl2.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"�ٰŸ�"));
		pl2.setLocation(10, 270);
		pl2.setSize(640, 160);
		pl2.setLayout(null);
		JPanel pl3 = new JPanel();
		pl3.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"������"));
		pl3.setLocation(10, 440);
		pl3.setSize(640, 160);
		pl3.setLayout(null);
		imageno = new JLabel("�̹��� ����");
		imageno.setLocation(380, 180);
		imageno.setSize(100, 20);
		c.add(imageno);
		panel.setLocation(20, 20); panel.setSize(320, 220);
		ja1 = new JTextArea();
		ja1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		JScrollPane scroll1 = new JScrollPane(ja1);
		scroll1.setBounds(20, 20, 605, 125); 
		pl2.add(scroll1);
		ja2 = new JTextArea();
		ja2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		JScrollPane scroll2 = new JScrollPane(ja2);
		scroll2.setBounds(20, 20, 605, 125); 
		pl3.add(scroll2);
		t = new JLabel(""); t.setBounds(580, 100, 30, 20); c.add(t);
		a = new JLabel(""); a.setBounds(580, 145, 30, 20); c.add(a);
		p = new JLabel(""); p.setBounds(580, 190, 40, 20); c.add(p);
		y = new JLabel(""); y.setBounds(580, 235, 60, 20); c.add(y);
		poi = new JLabel(""); poi.setBounds(580, 280, 30, 20); c.add(poi);
		tm = new JLabel(""); tm.setBounds(580, 90, 30, 20); c.add(tm);
		am = new JLabel(""); am.setBounds(580, 125, 30, 20); c.add(am);
		ym = new JLabel(""); ym.setBounds(580, 160, 30, 20); c.add(ym);
		gm = new JLabel(""); gm.setBounds(580, 195, 30, 20); c.add(gm);
		lm = new JLabel(""); lm.setBounds(580, 230, 30, 20); c.add(lm);
		pm = new JLabel(""); pm.setBounds(580, 265, 60, 20); c.add(pm);
		poim = new JLabel(""); poim.setBounds(580, 300, 30, 20); c.add(poim);
		t1 = new JLabel(""); t1.setBounds(650, 100, 300, 20); c.add(t1);
		a1 = new JLabel(""); a1.setBounds(650, 145, 300, 20); c.add(a1);
		p1 = new JLabel(""); p1.setBounds(650, 190, 300, 20); c.add(p1);
		y1 = new JLabel(""); y1.setBounds(650, 235, 300, 20); c.add(y1);
		poi1 = new JLabel(""); poi1.setBounds(650, 280, 300, 20); c.add(poi1);
		tm1 = new JLabel(""); tm1.setBounds(650, 90, 300, 20); c.add(tm1);
		am1 = new JLabel(""); am1.setBounds(650, 125, 300, 20); c.add(am1);
		ym1 = new JLabel(""); ym1.setBounds(650, 160, 300, 20); c.add(ym1);
		gm1 = new JLabel(""); gm1.setBounds(650, 195, 300, 20); c.add(gm1);
		lm1 = new JLabel(""); lm1.setBounds(650, 230, 300, 20); c.add(lm1);
		pm1 = new JLabel(""); pm1.setBounds(650, 265, 300, 20); c.add(pm1);
		poim1 = new JLabel(""); poim1.setBounds(650, 300, 300, 20); c.add(poim1);
		// �̹���
		imageLabel = new JLabel(); imageLabel.setBounds(320, 55, 200, 300); c.add(imageLabel);
		pl1.add(pl2); pl1.add(pl3); pl1.add(panel); c.add(pl1); 
		setSize(1000, 800); setVisible(true);
	}
	// thread�� ���� �����ϴ� ���� ���� �ð��� ������
	class MyLabel extends JLabel implements Runnable {
		private Thread timerThread = null;
		public MyLabel() {
			setText(makeClockText());
			setFont(new Font("TimesRoman", Font.ITALIC, 50));
			setHorizontalAlignment(JLabel.CENTER);
			timerThread = new Thread(MyLabel.this);
			timerThread.start();
		}
		public String makeClockText() {
			Calendar c = Calendar.getInstance();	
			int year = c.get(Calendar.YEAR); int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DAY_OF_MONTH); int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE); int second = c.get(Calendar.SECOND);
			String clockText = Integer.toString(year);
			clockText = clockText.concat("�� ");
			clockText = clockText.concat(Integer.toString(month));
			clockText = clockText.concat("�� ");
			clockText = clockText.concat(Integer.toString(day));
			clockText = clockText.concat("�� ");
			clockText = clockText.concat(Integer.toString(hour));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			return clockText;
		}
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){return;}
				setText(makeClockText());
			}
		}
	}
	// �߰� or ������ ������ �� �ߴ� ȭ����.
	class newWindow extends JFrame {
	    newWindow() {
	        setTitle("�Է�");
	        cp = getContentPane();
			cp.setLayout(null);
	        ButtonGroup MorB = new ButtonGroup();
			rb1 = new JRadioButton("Movie", true);
			rb1.addItemListener(new MyItemListener()); // movie ���� ��ư�� ������ ��ȭ�� �Է��ϱ� ���� �Է� ������� �����.
			rb2 = new JRadioButton("Book");
			rb2.addItemListener(new MyItemListener()); // book ���� ��ư�� ������ ������ �Է��ϱ� ���� �Է� ������� �����.
			MorB.add(rb1); MorB.add(rb2);
			rb1.setLocation(100, 20);
			rb1.setSize(60, 20);
			rb2.setLocation(160, 20);
			rb2.setSize(60, 20);
			cp.add(rb1); cp.add(rb2);
			// ���ķ� ��ȭ �Է��ϱ� ���� �Է� ��� ui
			panel1 = new JPanel();
			panel1.setBounds(3, 50, 327, 600);
			panel1.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"��ȭ ����"));
			cp.add(panel1);
			panel1.setLayout(null);
			title = new JLabel("����");
			title.setBounds(25, 40, 30, 20);
			title_area = new JTextField();
			title_area.setBounds(85, 25, 220, 40);
			director = new JLabel("����");
			director.setBounds(25, 90, 30, 20);
			dir_area = new JTextField();
			dir_area.setBounds(85, 75, 220, 40);
			actor = new JLabel("���");
			actor.setBounds(25, 140, 30, 20);
			actor_area = new JTextField();
			actor_area.setBounds(85, 125, 220, 40);
			ganre = new JLabel("�帣");
			ganre.setBounds(25, 190, 30, 20);
			ganre_Combo = new JComboBox<String>(ganre_vec);
			ganre_Combo.setBounds(85, 175, 220, 40);
			level = new JLabel("���");
			level.setBounds(25, 240, 30, 20);
			level_Combo = new JComboBox<String>(level_vec);
			level_Combo.setBounds(85, 225, 220, 40);
			open = new JLabel("�����⵵");
			open.setBounds(25, 290, 60, 20);
			open_Combo = new JComboBox<String>(open_vec);
			open_Combo.setBounds(85, 275, 220, 40);
			poster = new JLabel("������");
			poster.setBounds(25, 340, 40, 20);
			poster_area = new JTextField();
			poster_area.setBounds(85, 340, 130, 20);
			poster_but = new JButton("�ҷ�����");
			poster_but.setBounds(220, 337, 87, 25);
			poster_but.addActionListener(new OpenActionListener());
			score_movie = new JLabel("����");
			score_movie.setBounds(25, 390, 30, 20);
			slider_movie = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
			slider_movie.setPaintLabels(true);
			slider_movie.setPaintTicks(true);
			slider_movie.setPaintTrack(true);
			slider_movie.setMajorTickSpacing(1);
			slider_movie.setBounds(85, 375, 220, 40);
			plot = new JLabel("�ٰŸ�");
			plot.setBounds(25, 450, 40, 20);
			plot_area = new JTextArea();
			plot_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
			scroll3 = new JScrollPane(plot_area);
			scroll3.setBounds(85, 428, 220, 60);
			review = new JLabel("������");
			review.setBounds(25, 510, 40, 20);
			review_area = new JTextArea();
			review_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
		    scroll4 = new JScrollPane(review_area);
			scroll4.setBounds(85, 495, 220, 60);
			ok = new JButton("ok");
			// ok ��ư�� ������ ��ȭ ��ü�� �����ؼ� item �÷���, movie �÷��ǿ� �߰���. ������ ����Ʈ���� �߰���.
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Movie m = new Movie(title_area.getText(), dir_area.getText(), actor_area.getText(), 
							ganre_Combo.getSelectedItem().toString(), level_Combo.getSelectedItem().toString(), 
							open_Combo.getSelectedItem().toString(), poster_area.getText(), 
							slider_movie.getValue(), plot_area.getText(), review_area.getText());
					movie.add(m);
					item.add(new Item(title_area.getText(), slider_movie.getValue()));
					v.add(m.getHeadline());
					v_movie.add(m.getHeadline());
					vList.setListData(v);
					vList_movie.setListData(v_movie);
					// ���� ��ư ������ �� �Է� ����� �߰�, �ش��� ��쿡�� ok�� ���� ��� ����. ������ ����Ʈ���� �߰���.
					if(count == 0) {
						int where = item.size() -1;
						for (int i=0;i<item.size();i++) {
							if (changewhat.equals(item.get(i).headline)){
								item.get(i).setHeadline(item.get(where).headline);
								item.get(i).setPoints(item.get(where).points);
								item.remove(where);
								v.remove(where);
								
								break;}}
						for (int i=0;i<movie.size();i++) {
							where = movie.size() - 1;
							if (changewhat.equals(movie.get(i).headline)){
								movie.get(i).setHeadline(movie.get(where).headline);
								movie.get(i).setPoints(movie.get(where).points);
								movie.get(i).setMovie_actor(movie.get(where).movie_actor);
								movie.get(i).setMovie_director(movie.get(where).movie_director);
								movie.get(i).setMovie_ganre(movie.get(where).movie_ganre);
								movie.get(i).setMovie_level(movie.get(where).movie_level);
								movie.get(i).setMovie_open(movie.get(where).movie_open);
								movie.get(i).setMovie_plot(movie.get(where).movie_plot);
								movie.get(i).setMovie_poster(movie.get(where).movie_poster);
								movie.get(i).setMovie_review(movie.get(where).movie_review);
								movie.remove(where);
								v_movie.remove(where);
								break;}}
						collections.addItem();
						vList.setListData(v);
						vList_book.setListData(v_book);
						vList_movie.setListData(v_movie);
						vList_search.setListData(v_search);
						count = 1;
					}
					dispose();
				}
			});
			ok.setBounds(125, 565, 50, 25);
		    panel1.add(title); panel1.add(title_area); panel1.add(director); panel1.add(dir_area); panel1.add(actor); panel1.add(actor_area);
		    panel1.add(ganre); panel1.add(ganre_Combo); panel1.add(level); panel1.add(level_Combo); panel1.add(open); panel1.add(open_Combo);
		    panel1.add(poster); panel1.add(poster_area); panel1.add(poster_but); panel1.add(score_movie); panel1.add(slider_movie); 
		    panel1.add(plot); panel1.add(scroll3); panel1.add(review); panel1.add(scroll4); panel1.add(ok);
		    // ���� �Է��� ���� ui
			panel2 = new JPanel();
			panel2.setBounds(3, 50, 327, 600);
			panel2.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"���� ����"));
			panel2.setLayout(null);
			title_book = new JLabel("����");
			title_book.setBounds(25, 40, 30, 20);
			title_book_area = new JTextField();
			title_book_area.setBounds(85, 25, 220, 40);
			author = new JLabel("����");
			author.setBounds(25, 90, 30, 20);
			author_area = new JTextField();
			author_area.setBounds(85, 75, 220, 40);
			pub = new JLabel("���ǻ�");
			pub.setBounds(25, 140, 40, 20);
			pub_area = new JTextField();
			pub_area.setBounds(85, 125, 220, 40);
			year = new JLabel("���ǳ⵵");
			year.setBounds(25, 190, 60, 20);
			year_Combo = new JComboBox<String>(open_vec);
			year_Combo.setBounds(85, 175, 220, 40);
			image = new JLabel("å�̹���");
			image.setBounds(25, 240, 60, 20);
			image_area = new JTextField();
			image_area.setBounds(85, 240, 130, 20);
			image_but = new JButton("�ҷ�����");
			image_but.setBounds(220, 240, 87, 25);
			image_but.addActionListener(new OpenActionListener());
			score_book = new JLabel("����");
			score_book.setBounds(25, 290, 60, 20);
			slider_book = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
			slider_book.setPaintLabels(true);
			slider_book.setPaintTicks(true);
			slider_book.setPaintTrack(true);
			slider_book.setMajorTickSpacing(1);
			slider_book.setBounds(85, 290, 220, 40);
			intro = new JLabel("å�Ұ�");
			intro.setBounds(25, 360, 40, 20);
			intro_area = new JTextArea();
			intro_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
			scroll5 = new JScrollPane(intro_area);
			scroll5.setBounds(85, 340, 220, 60);
			re = new JLabel("������");
			re.setBounds(25, 440, 40, 20);
			re_area = new JTextArea();
			re_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
			scroll6 = new JScrollPane(re_area);
			scroll6.setBounds(85, 420, 220, 60);
			ok_b = new JButton("ok");
			// ok ��ư�� ������ ���� ��ü�� �����ؼ� item �÷���, book �÷��ǿ� �߰���. ������ ����Ʈ���� �߰���.
			ok_b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Book b = new Book(title_book_area.getText(), author_area.getText(), pub_area.getText(), 
							year_Combo.getSelectedItem().toString(), image_area.getText(), 
							slider_book.getValue(), intro_area.getText(), re_area.getText());
					book.add(b);
					item.add(new Item(title_book_area.getText(), slider_book.getValue()));
					v.add(b.getHeadline());
					v_book.add(b.getHeadline());
					vList.setListData(v);
					vList_book.setListData(v_book);
					// ���� ��ư ������ �� �Է� ����� �߰�, �ش��� ��쿡�� ok�� ���� ��� ����
					if(count == 0) {
						int where = item.size() -1;
						for (int i=0;i<item.size();i++) {
							if (changewhat.equals(item.get(i).headline)){
								item.get(i).setHeadline(item.get(where).headline);
								item.get(i).setPoints(item.get(where).points);
								item.remove(where);
								v.remove(where);
								break;}}
						for (int i=0;i<book.size();i++) {
							where = book.size() - 1;
							if (changewhat.equals(book.get(i).headline)){
								book.get(i).setHeadline(book.get(where).headline);
								book.get(i).setPoints(book.get(where).points);
								book.get(i).setBook_author(book.get(where).book_author);
								book.get(i).setBook_image(book.get(where).book_image);
								book.get(i).setBook_plot(book.get(where).book_plot);
								book.get(i).setBook_pub(book.get(where).book_pub);
								book.get(i).setBook_review(book.get(where).book_review);
								book.get(i).setBook_year(book.get(where).book_year);
								book.remove(where);
								v_book.remove(where);
								break;}}
						collections.addItem();
						vList.setListData(v);
						vList_book.setListData(v_book);
						vList_movie.setListData(v_movie);
						vList_search.setListData(v_search);
						count = 1;
					}
					dispose();
				}
			});
			ok_b.setBounds(125, 500, 50, 25);
			panel2.add(title_book); panel2.add(title_book_area); panel2.add(author); panel2.add(author_area); panel2.add(pub); 
			panel2.add(pub_area); panel2.add(year); panel2.add(year_Combo); panel2.add(image); panel2.add(image_area); panel2.add(image_but);
			panel2.add(score_book); panel2.add(slider_book); panel2.add(intro); panel2.add(scroll5); panel2.add(re); panel2.add(scroll6);
			panel2.add(ok_b);
	        setSize(350,700); setVisible(true);
	    }
	}
	// rb1�� ���õ� ��쿣, ��ȭ�� �Է¹ޱ� ���� ui�� ��. rb2�� ���õ� ��쿣, ������ �Է¹ޱ� ���� ui�� ��. 
	class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if(rb1.isSelected()) {
				panel2.setVisible(false);
				cp.add(panel1);
				panel1.setVisible(true);}
			else if(rb2.isSelected()) {
				panel1.setVisible(false);
				cp.add(panel2);
				panel2.setVisible(true);}
		}
	}
	// ���� �� ��ȭ �Է� ��Ŀ��� ������ Ȥ�� å�̹����� �ҷ����� ��ư�� ������ ���� ���� â�� �������, �̹��� ������ �����ϰ�
	// open ��ư�� ������ ���� ��ΰ� ������ Ȥ�� å�̹����� �ؽ�Ʈ �ʵ忡 �Էµ�.
	class OpenActionListener implements ActionListener{
		private JFileChooser chooser;
		public OpenActionListener() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter =
					new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			// ������ �������� ���� ���
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,
						"������ �������� �ʾҽ��ϴ�.", "���", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			poster_area.setText(filePath);
			image_area.setText(filePath);
		}
	}
	// ó�� ui���� �󼼺��⿡ �̹��� �κп� ���� ǥ��
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			g.drawLine(10, 10, 260, 300);
			g.drawLine(190, 10, 10, 220);
		}
	} 
	// JTabbedPane ����
	private JTabbedPane createTabbedPane() {
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.addTab("��ü", vList); // ��ü �ǿ����� ��ü �׸���� �� ����
		pane.addTab("��ȭ", vList_movie); // ��ȭ �ǿ����� ��ȭ �׸�鸸 ����
		pane.addTab("����", vList_book); // ���� �ǿ����� ���� �׸�鸸 ����
		searchp = new JPanel();
		searchp.setLayout(null);
		jfsearch = new JTextField();
		jfsearch.setBounds(70, 10, 130, 20);
		btnsearch = new JButton("�˻�");
		btnsearch.setBounds(205, 8, 60, 25);
		// �˻� ��ư�� ������,
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ItemCollections���� Item�� �˻��ϴ� �Լ� ����
				collections.searchItem();
			}
		});
		search_Combo = new JComboBox<String>(search_vec);
		search_Combo.setBounds(5, 8, 60, 25);
		vList_search.setBounds(0, 40, 300, 600);
		searchp.add(jfsearch); searchp.add(btnsearch); searchp.add(search_Combo); searchp.add(vList_search);
		// �˻� �ǿ����� ���ǿ� �´� �׸�鸸 ����
		pane.addTab("�˻�", searchp);
		return pane;
	}
	// ��ü�ǿ��� �׸��� �����ϸ� �ش� �׸��� �� ���� ����� ȭ�鿡 ��Ÿ��.
	class MouseAdapter1 extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int idx = vList.getSelectedIndex();
			vList_movie.clearSelection();
			vList_book.clearSelection();
			vList_search.clearSelection();
			changewhat = item.get(idx).headline;
			collections.addItem();
		}
	}
	// ��ȭ�ǿ��� �׸��� �����ϸ� �ش� �׸��� �� ���� ����� ȭ�鿡 ��Ÿ��.
	class MouseAdapter2 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int idx_m = vList_movie.getSelectedIndex();
			vList.clearSelection();
			vList_book.clearSelection();
			vList_search.clearSelection();
			t.setText(""); a.setText(""); p.setText(""); y.setText(""); poi.setText("");
			t1.setText(""); a1.setText(""); p1.setText(""); y1.setText(""); poi1.setText("");
			tm.setText("����"); am.setText("����"); ym.setText("���"); gm.setText("�帣"); lm.setText("���"); pm.setText("�����⵵"); poim.setText("����");
			tm1.setText(movie.get(idx_m).headline);
			am1.setText(movie.get(idx_m).movie_director);
			ym1.setText(movie.get(idx_m).movie_actor);
			gm1.setText(movie.get(idx_m).movie_ganre);
			lm1.setText(movie.get(idx_m).movie_level);
			pm1.setText(movie.get(idx_m).movie_open + "�⵵");
			String ss = Integer.toString(movie.get(idx_m).points);
			poim1.setText(ss + "��");
			ja1.setText(movie.get(idx_m).movie_plot);
			ja2.setText(movie.get(idx_m).movie_review);
			// �̹���
			ImageIcon originIcon = new ImageIcon(movie.get(idx_m).movie_poster);  
			Image originImg = originIcon.getImage(); 
			Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
			imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
			repaint(); revalidate(); setVisible(true);
		}	
	}
	// �����ǿ��� �׸��� �����ϸ� �ش� �׸��� �� ���� ����� ȭ�鿡 ��Ÿ��.
	class MouseAdapter3 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int idx_b = vList_book.getSelectedIndex();
			vList_movie.clearSelection();
			vList.clearSelection();
			vList_search.clearSelection();
			tm.setText(""); am.setText(""); pm.setText(""); ym.setText(""); poim.setText(""); lm.setText(""); gm.setText("");
			tm1.setText(""); am1.setText(""); pm1.setText(""); ym1.setText(""); poim1.setText("");  lm1.setText(""); gm1.setText("");
			t.setText("����"); a.setText("����"); p.setText("���ǻ�"); y.setText("���ǳ⵵"); poi.setText("����");
			t1.setText(book.get(idx_b).headline);
			a1.setText(book.get(idx_b).book_author);
			p1.setText(book.get(idx_b).book_pub);
			y1.setText(book.get(idx_b).book_year + "�⵵");
			String ss = Integer.toString(book.get(idx_b).points);
			poi1.setText(ss + "��");
			ja1.setText(book.get(idx_b).book_plot);
			ja2.setText(book.get(idx_b).book_review);
			ImageIcon originIcon = new ImageIcon(book.get(idx_b).book_image);  // �̹���
			Image originImg = originIcon.getImage(); 
			Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
			imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
			repaint(); revalidate(); setVisible(true);
		}
	}
	// �˻��ǿ��� �׸��� �����ϸ� �ش� �׸��� �� ���� ����� ȭ�鿡 ��Ÿ��.
	class MouseAdapter4 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int ids = vList_search.getSelectedIndex();
			vList.clearSelection();
			vList_book.clearSelection();
			vList_movie.clearSelection();
			changewhat = v_search.get(ids);
			collections.addItem();
		}
	}
	public class ItemCollections{
		//  Item�� ���, ����, ����, �˻��ϴ� ���� �޼ҵ带 �ۼ� 
		public void addItem() { // ������ �׸��� �� ���� ����� ȭ�鿡 ��Ÿ��
			for (int i=0; i<movie.size(); i++) { // movie �÷��ǿ� �ִ���
				if(changewhat.equals(movie.get(i).headline)) {
					t.setText(""); a.setText(""); p.setText(""); y.setText(""); poi.setText("");
					t1.setText(""); a1.setText(""); p1.setText(""); y1.setText(""); poi1.setText("");
					tm.setText("����"); am.setText("����"); ym.setText("���"); gm.setText("�帣"); lm.setText("���"); pm.setText("�����⵵"); poim.setText("����");
					tm1.setText(movie.get(i).headline);
					am1.setText(movie.get(i).movie_director);
					ym1.setText(movie.get(i).movie_actor);
					gm1.setText(movie.get(i).movie_ganre);
					lm1.setText(movie.get(i).movie_level);
					pm1.setText(movie.get(i).movie_open + "�⵵");
					String ss = Integer.toString(movie.get(i).points);
					poim1.setText(ss + "��");
					ja1.setText(movie.get(i).movie_plot);
					ja2.setText(movie.get(i).movie_review);
					ImageIcon originIcon = new ImageIcon(movie.get(i).movie_poster);  // �̹���
					Image originImg = originIcon.getImage(); 
					Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
					imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
					repaint(); revalidate(); setVisible(true);
					break;
				}	
			}
			for (int j=0; j<book.size(); j++) { // book �÷��ǿ� �ִ���
				if(changewhat.equals(book.get(j).headline)) {
					tm.setText(""); am.setText(""); pm.setText(""); ym.setText(""); poim.setText(""); lm.setText(""); gm.setText("");
					tm1.setText(""); am1.setText(""); pm1.setText(""); ym1.setText(""); poim1.setText("");  lm1.setText(""); gm1.setText("");
					t.setText("����"); a.setText("����"); p.setText("���ǻ�"); y.setText("���ǳ⵵"); poi.setText("����");
					t1.setText(book.get(j).headline);
					a1.setText(book.get(j).book_author);
					p1.setText(book.get(j).book_pub);
					y1.setText(book.get(j).book_year + "�⵵");
					String ss = Integer.toString(book.get(j).points);
					poi1.setText(ss + "��");
					ja1.setText(book.get(j).book_plot);
					ja2.setText(book.get(j).book_review);
					ImageIcon originIcon = new ImageIcon(book.get(j).book_image);   // �̹���
					Image originImg = originIcon.getImage(); 
					Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
					imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
					repaint(); revalidate(); setVisible(true);
					break;
				}	
			}
		}
		// �����ϱ�
		public void changeItem() {
			// ���õ� �� ��������
			if(vList.getSelectedIndex() != -1) {
				changewhat = v.get(vList.getSelectedIndex());}
			if(vList_movie.getSelectedIndex() != -1) {
				changewhat = v_movie.get(vList_movie.getSelectedIndex());}
			if(vList_book.getSelectedIndex() != -1) {
				changewhat = v_book.get(vList_book.getSelectedIndex());}
			if(vList_search.getSelectedIndex() != -1) {
				changewhat = v_search.get(vList_search.getSelectedIndex());}
			new newWindow();
			for (int i=0; i<movie.size(); i++) { // movie �÷��ǿ� �ִ���
				if(changewhat.equals(movie.get(i).headline)) {
					rb1.setSelected(true);
					title_area.setText(movie.get(i).headline); 
					dir_area.setText(movie.get(i).movie_director);
					actor_area.setText(movie.get(i).movie_actor); 
					ganre_Combo.setSelectedItem(movie.get(i).movie_ganre); 
					level_Combo.setSelectedItem(movie.get(i).movie_level); 
					open_Combo.setSelectedItem(movie.get(i).movie_open); 
					poster_area.setText(movie.get(i).movie_poster);
					slider_movie.setValue(movie.get(i).points);
					plot_area.setText(movie.get(i).movie_plot);
					review_area.setText(movie.get(i).movie_review);
					break;
				}	
			}
			for (int j=0; j<book.size(); j++) {  // book �÷��ǿ� �ִ���
				if(changewhat.equals(book.get(j).headline)) {
					rb2.setSelected(true);
					title_book_area.setText(book.get(j).headline); 
					author_area.setText(book.get(j).book_author);
					pub_area.setText(book.get(j).book_pub); 
					year_Combo.setSelectedItem(book.get(j).book_year); 
					image_area.setText(book.get(j).book_image);
					slider_book.setValue(book.get(j).points);
					intro_area.setText(book.get(j).book_plot);
					re_area.setText(book.get(j).book_review);
					break;
				}	
			}
		}
		// �����ϱ�
		public void deleteItem() {
			t.setText(""); a.setText(""); p.setText(""); y.setText(""); poi.setText(""); ja1.setText(""); ja2.setText("");
			t1.setText(""); a1.setText(""); p1.setText(""); y1.setText(""); poi1.setText(""); imageno.setText("�̹��� ����");
			tm.setText(""); am.setText(""); pm.setText(""); ym.setText(""); poim.setText(""); lm.setText(""); gm.setText("");
			tm1.setText(""); am1.setText(""); pm1.setText(""); ym1.setText(""); poim1.setText("");  lm1.setText(""); gm1.setText("");
			imageLabel.setIcon(new ImageIcon("")); 
			if(vList.getSelectedIndex() != -1) { // vList �߿��� ���õ� ���
				int idx = vList.getSelectedIndex();
				String str = item.get(idx).headline;
				for(int i=0;i<movie.size();i++) {
					if(str.equals(movie.get(i).headline)) {
						v_movie.remove(i);
						movie.remove(i);
					}	
				}
				for(int i=0;i<book.size();i++) {
					if(str.equals(book.get(i).headline)) {
						v_book.remove(i);
						book.remove(i);
					}	
				}
				v.remove(idx);
				item.remove(idx);
			}
			if(vList_movie.getSelectedIndex() != -1) { // vList_movie �߿��� ���õ� ���
				int id = vList_movie.getSelectedIndex();
				String str = movie.get(id).headline;
				for(int i=0;i<item.size();i++) {
					if(str.equals(item.get(i).headline)) {
						v.remove(i);
						item.remove(i);
					}	
				}
				v_movie.remove(id);
				movie.remove(id);
			}
			if(vList_book.getSelectedIndex() != -1) { // vList_book �߿��� ���õ� ���
				int ix = vList_book.getSelectedIndex();
				String str = book.get(ix).headline;
				for(int i=0;i<item.size();i++) {
					if(str.equals(item.get(i).headline)) {
						v.remove(i);
						item.remove(i);
					}	
				}
				v_book.remove(ix);
				book.remove(ix);
			}
		vList_book.setListData(v_book);
		vList_movie.setListData(v_movie);
		vList.setListData(v);
		vList_search.setListData(v_search);
		}
		public void searchItem() { // �˻��ϱ�
			if(search_Combo.getSelectedItem().toString().equals("����")) { // �޺��ڽ����� �˻��� ���
				String searchstr = jfsearch.getText();
				v_search.clear();
				for(int i=0;i<item.size();i++) {
					if(item.get(i).headline.contains(searchstr)) {
						v_search.add(v.get(i));
					}}}
			if(search_Combo.getSelectedItem().toString().equals("����")) { // �޺��ڽ����� ������ ���
				String searchstr = jfsearch.getText();
				v_search.clear();
				for(int i=0;i<item.size();i++) {
					if(item.get(i).points >= Integer.valueOf(searchstr)) {
						v_search.add(v.get(i));
					}}}
			vList_search.setListData(v_search);
		}
	}
	// ��ܿ� �޴� ����
	private void createMenu() {
		MenuActionListener listener = new MenuActionListener();
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu1 = new JMenu("����");
		JMenuItem sM1 = new JMenuItem("�ҷ�����");
		screenMenu1.add(sM1);
		sM1.addActionListener(new OpenActionListener1()); // �ҷ����� ��ư�� �������� ���
		JMenuItem sM2 = new JMenuItem("�����ϱ�");
		screenMenu1.add(sM2);
		sM2.addActionListener(new CloseActionListener()); // �����ϱ� ��ư�� �������� ���
		screenMenu1.addSeparator();
		JMenuItem sM3 = new JMenuItem("����");
		sM3.addActionListener(listener);
		screenMenu1.add(sM3);
		JMenu screenMenu2 = new JMenu("����");
		JMenuItem sM6 = new JMenuItem("�ý��� ����");
		sM6.addActionListener(listener);
		screenMenu2.add(sM6);
		mb.add(screenMenu1);
		mb.add(screenMenu2);
		setJMenuBar(mb);
	}
	class OpenActionListener1 implements ActionListener{ // �ҷ����� ��ư�� ������ ���� ���ñ� ��ȭ���ڰ� �������, ������ �����ϰ� open ��ư�� ������ ���� ������ ������� item, book, 
		// movie �÷��ǿ� �����ϰ�, �ҷ��� �׸���� �ٽ� ����Ʈ�� ������
		private JFileChooser chooser;
		public OpenActionListener1() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,
						"������ �������� �ʾҽ��ϴ�.", "���", 
						JOptionPane.WARNING_MESSAGE);
				return;}
			String filePath = chooser.getSelectedFile().getPath();
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
				try {
					Vector<Item> s = (Vector<Item>)ois.readObject();
					Vector<Movie> sm = (Vector<Movie>)ois.readObject();
					Vector<Book> sb = (Vector<Book>)ois.readObject();
					for (int i=0;i<s.size();i++) {
						item.add(s.elementAt(i));
						v.add(s.get(i).headline);
						vList.setListData(v);
					}
					for (int i=0;i<sm.size();i++) {
						movie.add(sm.elementAt(i));
						v_movie.add(sm.get(i).headline);
						vList_movie.setListData(v_movie);
					}
					for (int i=0;i<sb.size();i++) {
						book.add(sb.elementAt(i));
						v_book.add(sb.get(i).headline);
						vList_book.setListData(v_book);
					}
					vList_search.setListData(v_search);
				} catch (ClassNotFoundException e1) {
					
				}
				ois.close();
			} catch (FileNotFoundException e1) {
				System.out.print("����");
			} catch (IOException e1) {
				System.out.print("����");
			}
		}
	}
	class CloseActionListener implements ActionListener{ // �����ϱ� ��ư�� ������ ���� ���ñ� ��ȭ���ڰ� �������, ������ �����ϰų� ���� �̸��� �Է��ϰ� save ��ư�� ������
		// �ش� ������ movie, book, item �÷����� ������.
		private JFileChooser saveChooser;
		public CloseActionListener() {
			saveChooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = saveChooser.showSaveDialog(null);
			if(ret == JFileChooser.APPROVE_OPTION) {
				String filePath = saveChooser.getSelectedFile().getPath();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
					oos.writeObject(item);
					oos.writeObject(movie);
					oos.writeObject(book);
					oos.close();
				} catch (FileNotFoundException e1) {
					System.out.print("����");
				} catch (IOException e1) {
					System.out.print("����");
				}
				return;
			}
		}
	}
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "����": // ���Ḧ �����ϸ� ���α׷��� �����
				System.exit(0);
				break;
			case "�ý��� ����": // ���� ��, �Ʒ� �޽��� ���
				JOptionPane.showMessageDialog(null, "MyNotes �ý��� v 1.0 �Դϴ�.", "Massage", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// ����
		new LabFinalProject();
	}
}