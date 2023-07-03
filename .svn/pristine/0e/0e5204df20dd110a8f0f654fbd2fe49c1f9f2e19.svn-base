package common.eventfilters;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class NumberTraversalEventHandler implements EventHandler<KeyEvent> {

	private int max_Length=0;

	public NumberTraversalEventHandler(int max_Length) {
		super();
		this.max_Length = max_Length;
	}

	@Override public void handle(KeyEvent e) 
	{ 
		TextField txt_TextField = (TextField) e.getSource();
		
		if(txt_TextField.getText().length() >= this.max_Length) 
		{
			e.consume(); 
		} 
		if(e.getCharacter().matches("[0-9.]"))
		{ 
			if(txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]"))
			{ 
				e.consume(); }
			else 
				if(txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]"))
				{ 
					e.consume(); 
				} 
		}
		else
		{
			e.consume(); 
			} 
		} 
}