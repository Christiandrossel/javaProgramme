public class Datum
{
	public static void main(String args[])
	{

	
	System.out.println("Sie haben das Datum : " +args[0]+ " eingegeben");
	
	String[] dat = args[0].split("\\.");
	

	int tag = Integer.parseInt(dat[0]);
	int monat = Integer.parseInt(dat[1]);
	int jahr = Integer.parseInt(dat[2]);
	
	if (tag > 31 || tag < 1)
		{
			System.out.println("Bitte einen gueltigen Tag eingeben");
			System.exit(0);
		}
	
	if (monat > 12 || monat < 1)
		{
			System.out.println("Bitte einen gueltigen Monat eingeben");
			System.exit(0);
		}
	
	if (jahr > 2099 || jahr < 1900)
		{
			System.out.println("Bitte einen gueltigen Tag eingeben");
			System.exit(0);
		}
	
	int schaltjahr4, schaltjahr100, schaltjahr400 ;
	int rech, sjahr, nsjahr, tges,i, wtag;
	int tmonat = 0;
	int tageohneschaltjahr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	int tagemitschaltjahr[] = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	schaltjahr4   = jahr % 4 ;
	schaltjahr100 = jahr % 100 ; 
	schaltjahr400 = jahr % 400;
	
	if(schaltjahr4 == 0 && (schaltjahr100 != 0 || schaltjahr400 == 0 ))
		{
			System.out.println("Das eingeben Jahr ist EIN Schaltjahr");
			
			
			rech = jahr-1900;
			sjahr = (rech / 4 ) *366 ;
			nsjahr = (rech -(rech/4))*365;
			
			for ( i = 0 ; i< monat ; i++)
			{
				tmonat += tagemitschaltjahr[i];	
			}
			
			tges = sjahr + nsjahr + tag + tmonat +1;
			wtag = tges % 7;
						
			switch (wtag) 
			{
				case 0:  System.out.println("Dieser Tag faellt auf einen Donnerstag.");
				         break;
				case 1:  System.out.println("Dieser Tag faellt auf einen Freitag.");
				         break;
				case 2:  System.out.println("Dieser Tag faellt auf einen Samstag.");
				         break;
				case 3:  System.out.println("Dieser Tag faellt auf einen Sonntag.");
				         break;
				case 4:  System.out.println("Dieser Tag faellt auf einen Montag.");
				         break;
				case 5:  System.out.println("Dieser Tag faellt auf einen Dienstag");
				         break;
				case 6:  System.out.println("Dieser Tag faellt auf einen Mittwoch");
				         break;
      		}
		}
	else
		{
			System.out.println("Das eingegebene Jahr ist KEIN Schaltjahr");
			
			rech = jahr-1900;
			sjahr = (rech / 4 ) *366 ;
			nsjahr = (rech -(rech/4))*365;
			
			for ( i = 0 ; i< monat ; i++)
			{
				tmonat += tageohneschaltjahr[i];	
			}
			
			
			tges = sjahr + nsjahr + tag + tmonat;
			wtag = tges %7;
			
			switch (wtag) 
				{
				case 0:  System.out.println("Dieser Tag faellt auf einen Donnerstag.");
				         break;
				case 1:  System.out.println("Dieser Tag faellt auf einen Freitag.");
				         break;
				case 2:  System.out.println("Dieser Tag faellt auf einen Samstag.");
				         break;
				case 3:  System.out.println("Dieser Tag faellt auf einen Sonntag.");
				         break;
				case 4:  System.out.println("Dieser Tag faellt auf einen Montag.");
				         break;
				case 5:  System.out.println("Dieser Tag faellt auf einen Dienstag");
				         break;
				case 6:  System.out.println("Dieser Tag faellt auf einen Mittwoch");
				         break;
      		}
		}
	
	}
}