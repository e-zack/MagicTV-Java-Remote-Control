import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import main.java.com.github.mob41.magictv.remote.api.MagicTVRemote;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MTVRemoteUI extends JFrame {
	private JLabel lblStatus;
	private MagicTVRemote re;
	private String ip = null;
	private int port = 23456;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTVRemoteUI frame = new MTVRemoteUI();
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
	public MTVRemoteUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		setTitle("MagicTVRemote");
		
		setBounds(0, 0, 400, 760);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnChangeHost = new JButton("Change host");
		btnChangeHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputHost();
			}
		});
		panel.add(btnChangeHost, "2, 2");
		
		JButton btnPower = new JButton("Power");
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.power();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnPower, "6, 2");
		
		JButton btnGuide = new JButton("Guide");
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.guide();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnGuide, "2, 6");
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.menu();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnHome, "4, 6");
		
		JButton btnText = new JButton("Text");
		btnText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.text();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnText, "6, 6");
		
		JButton btnAspect = new JButton("Aspect");
		btnAspect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.aspect();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnAspect, "2, 8");
		
		JButton btnAudio = new JButton("Audio");
		btnAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.audio();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnAudio, "4, 8");
		
		JButton btnSubtitle = new JButton("Subtitle");
		btnSubtitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.subtitle();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnSubtitle, "6, 8");
		
		JButton btnBack = new JButton("< Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.back();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnBack, "2, 10");
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.info();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnInfo, "6, 10");
		
		JButton btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.up();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnUp, "4, 12");
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.left();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnLeft, "2, 14");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.ok();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnOk, "4, 14");
		
		JButton btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.right();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnRight, "6, 14");
		
		JButton btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.down();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnDown, "4, 16");
		
		JButton btnVol_up = new JButton("VOL +");
		btnVol_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.volume_up();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnVol_up, "2, 18");
		
		JButton btnCh_up = new JButton("CH +");
		btnCh_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.channel_up();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnCh_up, "6, 18");
		
		JButton btnMute = new JButton("Mute");
		btnMute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.mute();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnMute, "4, 20");
		
		JButton btnVol_down = new JButton("VOL -");
		btnVol_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.volume_down();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnVol_down, "2, 22");
		
		JButton btnCh_down = new JButton("CH -");
		btnCh_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.channel_down();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnCh_down, "6, 22");
		
		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.record();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnRecord, "2, 24");
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.pause();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnPause, "4, 24");
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.stop();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnStop, "6, 24");
		
		JButton btnFastreverse = new JButton("<< Fast-reverse");
		btnFastreverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.fast_reverse();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnFastreverse, "2, 26");
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.play();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnPlay, "4, 26");
		
		JButton btnFastforward = new JButton("Fast-forward >>");
		btnFastforward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.fast_forward();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnFastforward, "6, 26");
		
		JButton btnReplay = new JButton("|< Replay");
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.replay();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnReplay, "2, 28");
		
		JButton btnLiveSource = new JButton("Live source");
		btnLiveSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.source();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnLiveSource, "4, 28");
		
		JButton btnSkip = new JButton("Skip >|");
		btnSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.skip();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnSkip, "6, 28");
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.one();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_1, "2, 32");
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.two();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_2, "4, 32");
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.three();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_3, "6, 32");
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.four();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_4, "2, 34");
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.five();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_5, "4, 34");
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.six();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_6, "6, 34");
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.seven();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_7, "2, 36");
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.eight();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_8, "4, 36");
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.nine();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_9, "6, 36");
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.clear();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnClear, "2, 38");

		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.zero();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(button_0, "4, 38");
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.enter();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnEnter, "6, 38");
		
		JButton btnRed = new JButton("Red");
		btnRed.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRed.setForeground(Color.BLACK);
		btnRed.setBackground(Color.RED);
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.red();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnRed, "2, 40");
		
		JButton btnGreen = new JButton("Green");
		btnGreen.setForeground(Color.BLACK);
		btnGreen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGreen.setBackground(new Color(50, 205, 50));
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.green();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnGreen, "6, 40");
		
		JButton btnYellow = new JButton("Yellow");
		btnYellow.setForeground(Color.BLACK);
		btnYellow.setFont(new Font("PMingLiU", Font.BOLD, 12));
		btnYellow.setBackground(new Color(255, 255, 0));
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.yellow();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnYellow, "2, 42");
		
		JButton btnBlue = new JButton("Blue");
		btnBlue.setBackground(new Color(0, 0, 205));
		btnBlue.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBlue.setForeground(Color.BLACK);
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (re != null){
					try {
						re.blue();
						lblStatus.setText("Status: Sent. (" + Calendar.getInstance().getTimeInMillis() + ")");
					} catch (IOException e) {
						lblStatus.setText("Status: Send error: " + e + "(" + Calendar.getInstance().getTimeInMillis() + ")");
					}
				} else {
					lblStatus.setText("Status: No host is specified. (Instance not initialized) (" + Calendar.getInstance().getTimeInMillis() + ")");
				}
			}
		});
		panel.add(btnBlue, "6, 42");
		
		lblStatus = new JLabel("Status: No host specified.");
		panel.add(lblStatus, "2, 46, 5, 1");
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				//inputHost();
				findHost();
				String name = re.getModel();
				if (!name.equals("")){
					lblStatus.setText("Status: Connected to \"" + name + "\"");
				}
			}
		});
	}
	
	public void inputHost(){
		InputHostPanel inpanel = new InputHostPanel();
		int option = JOptionPane.showOptionDialog(this, inpanel, "Change hostname", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"OK", "Cancel"}, 1);
		
		if (option == 1 || option == JOptionPane.CLOSED_OPTION){
			return;
		}
		
		ip = inpanel.getHostname();
		port = inpanel.getPort();
		
		re = new MagicTVRemote(ip, port);
	}
	
	public void findHost(){
		MagicTVRemote r = new MagicTVRemote("255.255.255.255", 23456);
		
		re = new MagicTVRemote(r.sender_ip,r.sender_port);
	}
}

