import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myListModel extends AbstractListModel
{
public int getSize()	//lierfert eine information mit inhalt der elemente der Liste
{
	myData S;
	int i;
	for(i=0, S=(myData)L.getFirst();
	S!=null;
	S=(myData)L.getNext(),i++);
	return i;
}
public Object getElementAt(int index)
{
	myData S;
	return (myData)L.getIndexed(index);
}
static void main(String args[]){
	
}
}