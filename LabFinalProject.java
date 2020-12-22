import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

class Item implements Serializable{ // Item 클래스
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
class Movie extends Item implements Serializable{ // Movie 클래스
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
class Book extends Item implements Serializable{ // Book 클래스
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
	// 멤버변수 선언
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
	private String[] ganre_vec = {"드라마", "코미디", "액션", "판타지", "로맨스"};
	private String[] level_vec = {"전체", "12세 이상", "15세 이상", "청소년 관람 불가"};
	private String[] open_vec = {"2000","2001","2002","2003","2004","2005","2006","2007","2008",
			"2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
	String[] search_vec = {"제목", "별점"};
	JComboBox<String> ganre_Combo, level_Combo, open_Combo, year_Combo, search_Combo;
	JLabel t, a, p, y, poi, t1, a1, p1, y1, poi1, imageno, tm, am, pm, ym, poim, gm, lm, tm1, am1, pm1, ym1, poim1, gm1, lm1;
	ImageIcon icon; JLabel imageLabel;
	JScrollPane scroll3, scroll4, scroll5, scroll6;
	int count=1;
	public LabFinalProject() { // 첫 화면
		setTitle("JAVA 005분반 1611888 박유희");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu(); c.setLayout(null);
		time = new MyLabel();
		time.setFont(new Font("고딕", Font.ITALIC, 20));
		time.setBounds(600, 12, 500, 50); c.add(time);
		JLabel label = new JLabel("My Notes");
		label.setOpaque(true); 
		label.setForeground(new Color(0,0,153));
		label.setFont(new Font("고딕", Font.ITALIC | Font.BOLD, 40));
		label.setLocation(150, 10);
		label.setSize(200, 40); c.add(label);
		vList.addMouseListener(new MouseAdapter1());
		vList_movie.addMouseListener(new MouseAdapter2());
		vList_book.addMouseListener(new MouseAdapter3());
		vList_search.addMouseListener(new MouseAdapter4());
		btn1 = new JButton("추가"); // 추가 버튼을 누르면 newWindow() 실행, 도서 및 영화 정보를 입력할 수 있는 창이 뜸.
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new newWindow();
			}
		});
		btn1.setLocation(110, 690); btn1.setSize(60, 30); c.add(btn1);
		btn2 = new JButton("수정"); btn2.setLocation(540, 690); btn2.setSize(60, 30); c.add(btn2);
		// 수정 버튼을 누르면 입력 양식에 선택된 항목의 세부 내용들이 띄어지고, 수정할 내용 입력하고 ok를 누르면 해당 항목의 내용을 수정하고 그 결과가 보여짐
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
				collections.changeItem();
			}
		});
		btn3 = new JButton("삭제"); btn3.setLocation(620, 690); btn3.setSize(60, 30); c.add(btn3);
		// 삭제 버튼을 누르면 삭제 확인 메시지가 띄워짐
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result =  JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
				// "예"를 누르면 해당 항목을 컬렉션에서 삭제하고 변경된 목록을 다시 보여줌
				if(result == JOptionPane.YES_OPTION)
					collections.deleteItem();
			}
		});
		// TabbedPane 생성, 아래론 쭉 첫 화면 ui
		pane = createTabbedPane();
		pane.setLocation(5, 55);
		pane.setSize(280, 620);
		c.add(pane);
		JPanel pl1 = new JPanel();
		pl1.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"상세 보기"));
		pl1.setLocation(300, 58);
		pl1.setSize(660, 620);
		pl1.setLayout(null);
		JPanel pl2 = new JPanel();
		pl2.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"줄거리"));
		pl2.setLocation(10, 270);
		pl2.setSize(640, 160);
		pl2.setLayout(null);
		JPanel pl3 = new JPanel();
		pl3.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"감상평"));
		pl3.setLocation(10, 440);
		pl3.setSize(640, 160);
		pl3.setLayout(null);
		imageno = new JLabel("이미지 없음");
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
		// 이미지
		imageLabel = new JLabel(); imageLabel.setBounds(320, 55, 200, 300); c.add(imageLabel);
		pl1.add(pl2); pl1.add(pl3); pl1.add(panel); c.add(pl1); 
		setSize(1000, 800); setVisible(true);
	}
	// thread로 앱을 실행하는 동안 현재 시간을 보여줌
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
			clockText = clockText.concat("년 ");
			clockText = clockText.concat(Integer.toString(month));
			clockText = clockText.concat("월 ");
			clockText = clockText.concat(Integer.toString(day));
			clockText = clockText.concat("일 ");
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
	// 추가 or 수정을 눌렀을 때 뜨는 화면임.
	class newWindow extends JFrame {
	    newWindow() {
	        setTitle("입력");
	        cp = getContentPane();
			cp.setLayout(null);
	        ButtonGroup MorB = new ButtonGroup();
			rb1 = new JRadioButton("Movie", true);
			rb1.addItemListener(new MyItemListener()); // movie 라디오 버튼을 누르면 영화를 입력하기 위한 입력 양식으로 변경됨.
			rb2 = new JRadioButton("Book");
			rb2.addItemListener(new MyItemListener()); // book 라디오 버튼을 누르면 도서를 입력하기 위한 입력 양식으로 변경됨.
			MorB.add(rb1); MorB.add(rb2);
			rb1.setLocation(100, 20);
			rb1.setSize(60, 20);
			rb2.setLocation(160, 20);
			rb2.setSize(60, 20);
			cp.add(rb1); cp.add(rb2);
			// 이후론 영화 입력하기 위한 입력 양식 ui
			panel1 = new JPanel();
			panel1.setBounds(3, 50, 327, 600);
			panel1.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"영화 정보"));
			cp.add(panel1);
			panel1.setLayout(null);
			title = new JLabel("제목");
			title.setBounds(25, 40, 30, 20);
			title_area = new JTextField();
			title_area.setBounds(85, 25, 220, 40);
			director = new JLabel("감독");
			director.setBounds(25, 90, 30, 20);
			dir_area = new JTextField();
			dir_area.setBounds(85, 75, 220, 40);
			actor = new JLabel("배우");
			actor.setBounds(25, 140, 30, 20);
			actor_area = new JTextField();
			actor_area.setBounds(85, 125, 220, 40);
			ganre = new JLabel("장르");
			ganre.setBounds(25, 190, 30, 20);
			ganre_Combo = new JComboBox<String>(ganre_vec);
			ganre_Combo.setBounds(85, 175, 220, 40);
			level = new JLabel("등급");
			level.setBounds(25, 240, 30, 20);
			level_Combo = new JComboBox<String>(level_vec);
			level_Combo.setBounds(85, 225, 220, 40);
			open = new JLabel("개봉년도");
			open.setBounds(25, 290, 60, 20);
			open_Combo = new JComboBox<String>(open_vec);
			open_Combo.setBounds(85, 275, 220, 40);
			poster = new JLabel("포스터");
			poster.setBounds(25, 340, 40, 20);
			poster_area = new JTextField();
			poster_area.setBounds(85, 340, 130, 20);
			poster_but = new JButton("불러오기");
			poster_but.setBounds(220, 337, 87, 25);
			poster_but.addActionListener(new OpenActionListener());
			score_movie = new JLabel("별점");
			score_movie.setBounds(25, 390, 30, 20);
			slider_movie = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
			slider_movie.setPaintLabels(true);
			slider_movie.setPaintTicks(true);
			slider_movie.setPaintTrack(true);
			slider_movie.setMajorTickSpacing(1);
			slider_movie.setBounds(85, 375, 220, 40);
			plot = new JLabel("줄거리");
			plot.setBounds(25, 450, 40, 20);
			plot_area = new JTextArea();
			plot_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
			scroll3 = new JScrollPane(plot_area);
			scroll3.setBounds(85, 428, 220, 60);
			review = new JLabel("감상평");
			review.setBounds(25, 510, 40, 20);
			review_area = new JTextArea();
			review_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
		    scroll4 = new JScrollPane(review_area);
			scroll4.setBounds(85, 495, 220, 60);
			ok = new JButton("ok");
			// ok 버튼을 누르면 영화 객체를 생성해서 item 컬랙션, movie 컬랙션에 추가됨. 각각의 리스트에도 추가됨.
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
					// 수정 버튼 눌렀을 때 입력 양식이 뜨고, 해당의 경우에서 ok를 누른 경우 실행. 각각의 리스트에도 추가됨.
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
		    // 도서 입력을 위한 ui
			panel2 = new JPanel();
			panel2.setBounds(3, 50, 327, 600);
			panel2.setBorder(new TitledBorder(new LineBorder(new Color(176, 196, 222)),"도서 정보"));
			panel2.setLayout(null);
			title_book = new JLabel("제목");
			title_book.setBounds(25, 40, 30, 20);
			title_book_area = new JTextField();
			title_book_area.setBounds(85, 25, 220, 40);
			author = new JLabel("저자");
			author.setBounds(25, 90, 30, 20);
			author_area = new JTextField();
			author_area.setBounds(85, 75, 220, 40);
			pub = new JLabel("출판사");
			pub.setBounds(25, 140, 40, 20);
			pub_area = new JTextField();
			pub_area.setBounds(85, 125, 220, 40);
			year = new JLabel("출판년도");
			year.setBounds(25, 190, 60, 20);
			year_Combo = new JComboBox<String>(open_vec);
			year_Combo.setBounds(85, 175, 220, 40);
			image = new JLabel("책이미지");
			image.setBounds(25, 240, 60, 20);
			image_area = new JTextField();
			image_area.setBounds(85, 240, 130, 20);
			image_but = new JButton("불러오기");
			image_but.setBounds(220, 240, 87, 25);
			image_but.addActionListener(new OpenActionListener());
			score_book = new JLabel("별점");
			score_book.setBounds(25, 290, 60, 20);
			slider_book = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
			slider_book.setPaintLabels(true);
			slider_book.setPaintTicks(true);
			slider_book.setPaintTrack(true);
			slider_book.setMajorTickSpacing(1);
			slider_book.setBounds(85, 290, 220, 40);
			intro = new JLabel("책소개");
			intro.setBounds(25, 360, 40, 20);
			intro_area = new JTextArea();
			intro_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
			scroll5 = new JScrollPane(intro_area);
			scroll5.setBounds(85, 340, 220, 60);
			re = new JLabel("감상평");
			re.setBounds(25, 440, 40, 20);
			re_area = new JTextArea();
			re_area.setBorder(BorderFactory.createLineBorder(new Color(176, 196, 222)));
			scroll6 = new JScrollPane(re_area);
			scroll6.setBounds(85, 420, 220, 60);
			ok_b = new JButton("ok");
			// ok 버튼을 누르면 도서 객체를 생성해서 item 컬랙션, book 컬랙션에 추가됨. 각각의 리스트에도 추가됨.
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
					// 수정 버튼 눌렀을 때 입력 양식이 뜨고, 해당의 경우에서 ok를 누른 경우 실행
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
	// rb1가 선택된 경우엔, 영화를 입력받기 위한 ui가 뜸. rb2가 선택된 경우엔, 도서를 입력받기 위한 ui가 뜸. 
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
	// 도서 및 영화 입력 양식에서 포스터 혹은 책이미지의 불러오기 버튼을 누르면 파일 열기 창이 띄어지고, 이미지 파일을 선택하고
	// open 버튼을 누르면 파일 경로가 포스터 혹은 책이미지의 텍스트 필드에 입력됨.
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
			// 파일을 선택하지 않은 경우
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,
						"파일을 선택하지 않았습니다.", "경고", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			poster_area.setText(filePath);
			image_area.setText(filePath);
		}
	}
	// 처음 ui에서 상세보기에 이미지 부분에 엑스 표시
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.gray);
			g.drawLine(10, 10, 260, 300);
			g.drawLine(190, 10, 10, 220);
		}
	} 
	// JTabbedPane 생성
	private JTabbedPane createTabbedPane() {
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.addTab("전체", vList); // 전체 탭에서는 전체 항목들이 다 보임
		pane.addTab("영화", vList_movie); // 영화 탭에서는 영화 항목들만 보임
		pane.addTab("도서", vList_book); // 도서 탭에서는 도서 항목들만 보임
		searchp = new JPanel();
		searchp.setLayout(null);
		jfsearch = new JTextField();
		jfsearch.setBounds(70, 10, 130, 20);
		btnsearch = new JButton("검색");
		btnsearch.setBounds(205, 8, 60, 25);
		// 검색 버튼을 누르면,
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ItemCollections에서 Item을 검색하는 함수 실행
				collections.searchItem();
			}
		});
		search_Combo = new JComboBox<String>(search_vec);
		search_Combo.setBounds(5, 8, 60, 25);
		vList_search.setBounds(0, 40, 300, 600);
		searchp.add(jfsearch); searchp.add(btnsearch); searchp.add(search_Combo); searchp.add(vList_search);
		// 검색 탭에서는 조건에 맞는 항목들만 보임
		pane.addTab("검색", searchp);
		return pane;
	}
	// 전체탭에서 항목을 선택하면 해당 항목의 상세 보기 결과가 화면에 나타남.
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
	// 영화탭에서 항목을 선택하면 해당 항목의 상세 보기 결과가 화면에 나타남.
	class MouseAdapter2 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int idx_m = vList_movie.getSelectedIndex();
			vList.clearSelection();
			vList_book.clearSelection();
			vList_search.clearSelection();
			t.setText(""); a.setText(""); p.setText(""); y.setText(""); poi.setText("");
			t1.setText(""); a1.setText(""); p1.setText(""); y1.setText(""); poi1.setText("");
			tm.setText("제목"); am.setText("감독"); ym.setText("배우"); gm.setText("장르"); lm.setText("등급"); pm.setText("개봉년도"); poim.setText("별점");
			tm1.setText(movie.get(idx_m).headline);
			am1.setText(movie.get(idx_m).movie_director);
			ym1.setText(movie.get(idx_m).movie_actor);
			gm1.setText(movie.get(idx_m).movie_ganre);
			lm1.setText(movie.get(idx_m).movie_level);
			pm1.setText(movie.get(idx_m).movie_open + "년도");
			String ss = Integer.toString(movie.get(idx_m).points);
			poim1.setText(ss + "점");
			ja1.setText(movie.get(idx_m).movie_plot);
			ja2.setText(movie.get(idx_m).movie_review);
			// 이미지
			ImageIcon originIcon = new ImageIcon(movie.get(idx_m).movie_poster);  
			Image originImg = originIcon.getImage(); 
			Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
			imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
			repaint(); revalidate(); setVisible(true);
		}	
	}
	// 도서탭에서 항목을 선택하면 해당 항목의 상세 보기 결과가 화면에 나타남.
	class MouseAdapter3 extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int idx_b = vList_book.getSelectedIndex();
			vList_movie.clearSelection();
			vList.clearSelection();
			vList_search.clearSelection();
			tm.setText(""); am.setText(""); pm.setText(""); ym.setText(""); poim.setText(""); lm.setText(""); gm.setText("");
			tm1.setText(""); am1.setText(""); pm1.setText(""); ym1.setText(""); poim1.setText("");  lm1.setText(""); gm1.setText("");
			t.setText("제목"); a.setText("저자"); p.setText("출판사"); y.setText("출판년도"); poi.setText("별점");
			t1.setText(book.get(idx_b).headline);
			a1.setText(book.get(idx_b).book_author);
			p1.setText(book.get(idx_b).book_pub);
			y1.setText(book.get(idx_b).book_year + "년도");
			String ss = Integer.toString(book.get(idx_b).points);
			poi1.setText(ss + "점");
			ja1.setText(book.get(idx_b).book_plot);
			ja2.setText(book.get(idx_b).book_review);
			ImageIcon originIcon = new ImageIcon(book.get(idx_b).book_image);  // 이미지
			Image originImg = originIcon.getImage(); 
			Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
			imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
			repaint(); revalidate(); setVisible(true);
		}
	}
	// 검색탭에서 항목을 선택하면 해당 항목의 상세 보기 결과가 화면에 나타남.
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
		//  Item을 등록, 수정, 삭제, 검색하는 등의 메소드를 작성 
		public void addItem() { // 선택한 항목의 상세 보기 결과가 화면에 나타남
			for (int i=0; i<movie.size(); i++) { // movie 컬렉션에 있는지
				if(changewhat.equals(movie.get(i).headline)) {
					t.setText(""); a.setText(""); p.setText(""); y.setText(""); poi.setText("");
					t1.setText(""); a1.setText(""); p1.setText(""); y1.setText(""); poi1.setText("");
					tm.setText("제목"); am.setText("감독"); ym.setText("배우"); gm.setText("장르"); lm.setText("등급"); pm.setText("개봉년도"); poim.setText("별점");
					tm1.setText(movie.get(i).headline);
					am1.setText(movie.get(i).movie_director);
					ym1.setText(movie.get(i).movie_actor);
					gm1.setText(movie.get(i).movie_ganre);
					lm1.setText(movie.get(i).movie_level);
					pm1.setText(movie.get(i).movie_open + "년도");
					String ss = Integer.toString(movie.get(i).points);
					poim1.setText(ss + "점");
					ja1.setText(movie.get(i).movie_plot);
					ja2.setText(movie.get(i).movie_review);
					ImageIcon originIcon = new ImageIcon(movie.get(i).movie_poster);  // 이미지
					Image originImg = originIcon.getImage(); 
					Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
					imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
					repaint(); revalidate(); setVisible(true);
					break;
				}	
			}
			for (int j=0; j<book.size(); j++) { // book 컬렌션에 있는지
				if(changewhat.equals(book.get(j).headline)) {
					tm.setText(""); am.setText(""); pm.setText(""); ym.setText(""); poim.setText(""); lm.setText(""); gm.setText("");
					tm1.setText(""); am1.setText(""); pm1.setText(""); ym1.setText(""); poim1.setText("");  lm1.setText(""); gm1.setText("");
					t.setText("제목"); a.setText("저자"); p.setText("출판사"); y.setText("출판년도"); poi.setText("별점");
					t1.setText(book.get(j).headline);
					a1.setText(book.get(j).book_author);
					p1.setText(book.get(j).book_pub);
					y1.setText(book.get(j).book_year + "년도");
					String ss = Integer.toString(book.get(j).points);
					poi1.setText(ss + "점");
					ja1.setText(book.get(j).book_plot);
					ja2.setText(book.get(j).book_review);
					ImageIcon originIcon = new ImageIcon(book.get(j).book_image);   // 이미지
					Image originImg = originIcon.getImage(); 
					Image changedImg= originImg.getScaledInstance(200, 235, Image.SCALE_SMOOTH );
					imageLabel.setIcon(new ImageIcon(changedImg)); imageno.setText("");
					repaint(); revalidate(); setVisible(true);
					break;
				}	
			}
		}
		// 수정하기
		public void changeItem() {
			// 선택된 값 가져오기
			if(vList.getSelectedIndex() != -1) {
				changewhat = v.get(vList.getSelectedIndex());}
			if(vList_movie.getSelectedIndex() != -1) {
				changewhat = v_movie.get(vList_movie.getSelectedIndex());}
			if(vList_book.getSelectedIndex() != -1) {
				changewhat = v_book.get(vList_book.getSelectedIndex());}
			if(vList_search.getSelectedIndex() != -1) {
				changewhat = v_search.get(vList_search.getSelectedIndex());}
			new newWindow();
			for (int i=0; i<movie.size(); i++) { // movie 컬렉션에 있는지
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
			for (int j=0; j<book.size(); j++) {  // book 컬렉션에 있는지
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
		// 삭제하기
		public void deleteItem() {
			t.setText(""); a.setText(""); p.setText(""); y.setText(""); poi.setText(""); ja1.setText(""); ja2.setText("");
			t1.setText(""); a1.setText(""); p1.setText(""); y1.setText(""); poi1.setText(""); imageno.setText("이미지 없음");
			tm.setText(""); am.setText(""); pm.setText(""); ym.setText(""); poim.setText(""); lm.setText(""); gm.setText("");
			tm1.setText(""); am1.setText(""); pm1.setText(""); ym1.setText(""); poim1.setText("");  lm1.setText(""); gm1.setText("");
			imageLabel.setIcon(new ImageIcon("")); 
			if(vList.getSelectedIndex() != -1) { // vList 중에서 선택된 경우
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
			if(vList_movie.getSelectedIndex() != -1) { // vList_movie 중에서 선택된 경우
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
			if(vList_book.getSelectedIndex() != -1) { // vList_book 중에서 선택된 경우
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
		public void searchItem() { // 검색하기
			if(search_Combo.getSelectedItem().toString().equals("제목")) { // 콤보박스에서 검색인 경우
				String searchstr = jfsearch.getText();
				v_search.clear();
				for(int i=0;i<item.size();i++) {
					if(item.get(i).headline.contains(searchstr)) {
						v_search.add(v.get(i));
					}}}
			if(search_Combo.getSelectedItem().toString().equals("별점")) { // 콤보박스에서 별점인 경우
				String searchstr = jfsearch.getText();
				v_search.clear();
				for(int i=0;i<item.size();i++) {
					if(item.get(i).points >= Integer.valueOf(searchstr)) {
						v_search.add(v.get(i));
					}}}
			vList_search.setListData(v_search);
		}
	}
	// 상단에 메뉴 생성
	private void createMenu() {
		MenuActionListener listener = new MenuActionListener();
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu1 = new JMenu("파일");
		JMenuItem sM1 = new JMenuItem("불러오기");
		screenMenu1.add(sM1);
		sM1.addActionListener(new OpenActionListener1()); // 불러오기 버튼이 눌러지는 경우
		JMenuItem sM2 = new JMenuItem("저장하기");
		screenMenu1.add(sM2);
		sM2.addActionListener(new CloseActionListener()); // 저장하기 버튼이 눌러지는 경우
		screenMenu1.addSeparator();
		JMenuItem sM3 = new JMenuItem("종료");
		sM3.addActionListener(listener);
		screenMenu1.add(sM3);
		JMenu screenMenu2 = new JMenu("도움말");
		JMenuItem sM6 = new JMenuItem("시스템 정보");
		sM6.addActionListener(listener);
		screenMenu2.add(sM6);
		mb.add(screenMenu1);
		mb.add(screenMenu2);
		setJMenuBar(mb);
	}
	class OpenActionListener1 implements ActionListener{ // 불러오기 버튼을 누르면 파일 선택기 대화상자가 띄어지고, 파일을 선택하고 open 버튼을 누르면 파일 내용을 가지고와 item, book, 
		// movie 컬렉션에 저장하고, 불러온 항목들을 다시 리스트에 보여줌
		private JFileChooser chooser;
		public OpenActionListener1() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,
						"파일을 선택하지 않았습니다.", "경고", 
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
				System.out.print("오류");
			} catch (IOException e1) {
				System.out.print("오류");
			}
		}
	}
	class CloseActionListener implements ActionListener{ // 저장하기 버튼을 누르면 파일 선택기 대화상자가 띄워지고, 파일을 선택하거나 파일 이름을 입력하고 save 버튼을 누르면
		// 해당 파일의 movie, book, item 컬레션을 저장함.
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
					System.out.print("오류");
				} catch (IOException e1) {
					System.out.print("오류");
				}
				return;
			}
		}
	}
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "종료": // 종료를 선택하면 프로그래밍 종료됨
				System.exit(0);
				break;
			case "시스템 정보": // 선택 시, 아래 메시지 출력
				JOptionPane.showMessageDialog(null, "MyNotes 시스템 v 1.0 입니다.", "Massage", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// 실행
		new LabFinalProject();
	}
}