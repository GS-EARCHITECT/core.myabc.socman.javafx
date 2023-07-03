package common.eventfilters;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import com.sun.javafx.scene.control.skin.TextFieldSkin;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EnterKeyButtonTraversalEventHandler implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) 
    {
    	if (event.getCode() == KeyCode.ENTER) 
    	 {
    		 Node node = (Node) event.getSource();    	 
    		 ButtonSkin skin = (ButtonSkin) ((Button)node).getSkin();
             Button button = (Button)node;
             button.fire();
       	     event.consume(); 
    	 }		 
         }
    }