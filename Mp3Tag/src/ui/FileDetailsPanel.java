package ui;

import javax.swing.JPanel;
import files.Mp3File;
import javax.swing.JTextArea;

public class FileDetailsPanel extends JPanel {
	
	Mp3File file;
	
	//Label Text Areas
	JTextArea artistLabel;		JTextArea albumArtistLabel;
	JTextArea albumLabel;			JTextArea titleLabel;
	JTextArea trackLabel;			JTextArea discLabel;
	JTextArea yearLabel;			JTextArea commentLabel;
	
	//Value Text Areas
	JTextArea artistValue;		JTextArea albumArtistValue;
	JTextArea albumValue;			JTextArea titleValue;
	JTextArea trackValue;			JTextArea discValue;
	JTextArea yearValue;			JTextArea commentValue;
	
	public FileDetailsPanel() {
		artistLabel = new JTextArea("Artist: ");
		albumArtistLabel = new JTextArea("Album Artist: ");
		albumLabel = new JTextArea("Album: ");
		titleLabel = new JTextArea("Title: ");
		trackLabel = new JTextArea("Track#: ");
		discLabel = new JTextArea("Disc: ");
		yearLabel = new JTextArea("Year: ");
		commentLabel = new JTextArea("Comment: ");
		artistValue = new JTextArea();
		albumArtistValue = new JTextArea();
		albumValue = new JTextArea();
		titleValue = new JTextArea();
		trackValue = new JTextArea();
		discValue = new JTextArea();
		yearValue = new JTextArea();
		commentValue = new JTextArea();
		this.add(artistLabel);		this.add(albumArtistLabel);
		this.add(albumLabel);			this.add(titleLabel);
		this.add(trackLabel);			this.add(discLabel);
		this.add(yearLabel);			this.add(commentLabel);
	}
	
	public void loadMp3File(Mp3File f) {
		this.file = f;
	}
	
	public void refresh() {
		artistValue.setText(file.getArtist());
		albumArtistValue.setText(file.getAlbumArtist());
		albumValue.setText(file.getAlbum());
		titleValue.setText(file.getTitle());
		trackValue.setText(file.getTrack());
		discValue.setText(file.getDisc());
		yearValue.setText(file.getYear());
		commentValue.setText(file.getComment());
	}
	
}
