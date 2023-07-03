package common.eventfilters;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class AlphabetTraversalEventHandler implements EventHandler<KeyEvent> {

	private int max_Length=0;

	public AlphabetTraversalEventHandler(int max_Length) {
		super();
		this.max_Length = max_Length;
	}

	@Override public void handle(KeyEvent e) 
	{ 
	TextField txt_TextField = (TextField) e.getSource(); 
	if (txt_TextField.getText().length() >= max_Length) 
	{ 
		e.consume(); } 
	if(e.getCharacter().matches("[A-Za-z]"))
	{
		
	}else
	{
		e.consume(); 
		}
	} 
	}
