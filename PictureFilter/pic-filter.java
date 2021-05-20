import java.awt.*;
 import java.awt.image.*;
 import java.awt.event.*;
 
  class pic_filter extends Panel{
	 
	 private Image Img,Imgf;
	 class myFilter extends RGBImageFilter{
		 int a,w,h,b;
		 public myFilter(int w, int h, int b){
			 canFilterIndexColorModel = false;
			 this.w=w;
			 this.h=h;
			 this.b=b;
			
		 }		 
		 public int filterRGB(int x, int y, int rgb){
			if (x<b && y>=x && y<(h-x)  )    return 0xffff0000;//rgb|a|0xff0000; 		links
			if (y<b && x>y && x<(w-y) )     return 0xff000000;//rgb|a|0xff0000;		oben
			if ((w-x)<b && y<(h-b))  		return 0xffff0000;//rgb|a|0xff0000;	rechts
			if ((h-y)<b && x<(w-b))  		return 0xff000000;//rgb|a|0xff0000;	unten
			return rgb;
		 }
	 }
	 
	 pic_filter(Image Img){
			this.Img = Img;
			MediaTracker M=new MediaTracker(this);
			M.addImage(Img, 1);
			try{
				M.waitForID(1);
			}
			catch (Exception e){}
			Imgf=createImage(
				new FilteredImageSource(
						Img.getSource(),
						new myFilter(Img.getWidth(this),Img.getHeight(this),20)
					)
				);
			
	}	 
	
	public void paint (Graphics g){
		g.drawImage(Imgf, 0, 0,this);
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(Img.getWidth(this),Img.getHeight(this));
	}
	 
	 
	public static void main(String args[]){
		Frame F=new Frame("Pic-Filter");
		Image I=F.getToolkit().getImage("lok.gif");
		pic_filter P=new pic_filter(I);
		F.add(P);
				F.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
						}
		});	
		F.pack();
		F.setVisible(true);	
		