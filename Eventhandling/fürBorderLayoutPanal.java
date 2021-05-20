public void actionPerformed(ActionEvent e){
	
	/*Damit wird ein Eventlistener auf dem Button gegeben
	und er gibt die Buttons auf die Konsole aus*/
	System.out.println(e.getActionCommand);
}


public BorderLayoutpanel(){
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	
	//alternativ um jeden button einzeln ein Listener hinzuzufügen
	b5.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){System.out.println("b5 "+e.getActionCommand()); }});
}