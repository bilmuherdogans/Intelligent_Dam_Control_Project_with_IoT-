package sunucu;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Logger;
import com.firebase.client.ValueEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
public class sunucu
{
   public static String sicaklik,nem,yukseklik;
   public static int sicakdeger=0;
   public static double nemdeger=0.0;
   public static double ruzgardeger=0.0;
   public static double yukseklikDeger=0.0;
   public static double ew=0.0;
   public static double E=0.0;
   public static double Esaniye,hesap,saniye,suankadarbuharlasan,gun,islem,saat,dakika;
   public static double katsayi=0.60;
   public static double miktar=4000;
   public static ArrayList<String> ruzgar=new ArrayList<String>();
   public static void main(String[] args) throws Exception{
   Timer myTimer=new Timer();
   Firebase.getDefaultConfig().setLogLevel(Logger.Level.INFO);
   Random r=new Random();      
   Firebase firebaseNesnesi = new Firebase("https://taslak3-189b1.firebaseio.com/");
   System.out.println("Veri tabanina baglaniliyor..");
      
      firebaseNesnesi.addValueEventListener(new ValueEventListener() {
      public void onDataChange(DataSnapshot ds) {
                try {
                    
                } catch (NullPointerException e) {
                   
                }
            }
 
         
            public void onCancelled(FirebaseError fe) {
          
            }
        });
 
        
        firebaseNesnesi.authWithCustomToken("yRbx5iO7cDal6OdNtv53IwvmO24KANDDCpnSNJYX", new Firebase.AuthResultHandler() {
           
            public void onAuthenticated(AuthData ad) {
                System.out.println("Yetkilendirme islemi tamamlandi. Veri girisi yapabilirsiniz..");
            }
 
            @Override
            public void onAuthenticationError(FirebaseError fe) {
                System.out.println("Yetkilendirme hatasi : " + fe.getMessage());
            }
        });
             
        TimerTask gorev =new TimerTask() {
        public void run() 
        {
           try
           {
               String url="http://87.118.114.103/list";        
               URL obj=new URL(url);
               HttpURLConnection con=(HttpURLConnection) obj.openConnection(); 
               con.setRequestProperty("Accept","application/vnd.kafka.json.v2+json");
               con.setRequestMethod("GET");
               int responseCode =con.getResponseCode();
               BufferedReader in = new BufferedReader(
               new InputStreamReader(con.getInputStream()));
               String inputLine;
               String s= null;
               String a="[]";
               String b = null;
               String d = null;
               while ((inputLine = in.readLine()) != null) {
               s=inputLine;
           } 
           
           
               if(s.equals(a))
               { 
               }
               else
               {
                   b=s;
               }
               
             in.close();
             if(b.equalsIgnoreCase(null))
             {
        
             }
             else
             {
                 d=b;      
                 JSONArray sourceArray = new JSONArray(d);       
                 for (int i = 0; i < sourceArray.length(); i++)
                 {
                     String name=sourceArray.getJSONObject(i).toString();
                      JSONObject deger = new JSONObject(name);
                      sicaklik= (String) deger.get("sicaklik").toString(); 
                      nem= (String) deger.get("nem").toString(); 
                      yukseklik= (String) deger.get("yukseklik").toString();

                 }
            
             }
             
             sicakdeger=Integer.parseInt(sicaklik);
             nemdeger=Double.parseDouble(nem);
             yukseklikDeger=Double.parseDouble(yukseklik);
             ruzgardeger=Double.parseDouble(getir());
             System.out.println("sicaklik " + sicakdeger);   
             firebaseNesnesi.child("sicaklik").child("sicaklik").setValue(sicakdeger); 
             System.out.println("nem " + nemdeger); 
             firebaseNesnesi.child("nem").child("nem").setValue(nemdeger); 
             System.out.println("yukseklik " +yukseklikDeger);  
             firebaseNesnesi.child("yukseklik").child("yukseklik").setValue(yukseklikDeger); 
             System.out.println("ruzgarHizi " +ruzgardeger); 
             firebaseNesnesi.child("ruzgarHizi").child("ruzgarHizi").setValue(ruzgardeger); 
             switch (sicakdeger) 
             {
                  case 1 :ew=4.92;break;
                  case 11 :ew=9.84;break;
                  case 21 :ew=18.65;break;
                  case 31 :ew=31.80;break;
                  case 2 :ew=5.29;break;
                  case 12 :ew=10.52;break;
                  case 22 :ew=19.82;break;
                  case 32 :ew=33.40;break;
                  case 3 :ew=5.68;break;
                  case 13 :ew=11.23;break;
                  case 23 :ew=21.05;break;
                  case 33 :ew=35.65;break;
                  case 4 :ew=6.10;break;
                  case 14 :ew=11.98;break;
                  case 24 :ew=22.37;break;
                  case 34 :ew=38.65;break;
                  case 5 :ew=6.54;break;
                  case 15 :ew=12.78;break;
                  case 25 :ew=23.75;break;
                  case 35 :ew=42.20;break;
                  case 6 :ew=7.01;break;
                  case 16 :ew=13.63;break;
                  case 26 :ew=25.31;break;
                  case 36 :ew=44.50;break;
                  case 7 :ew=7.51;break;
                  case 17 :ew=14.53;break;
                  case 27 :ew=26.86;break;
                  case 37 :ew=47.10;break;
                  case 8 :ew=8.04;break;
                  case 18 :ew=15.46;break;
                  case 28 :ew=28.32;break;
                  case 38 :ew=52.60;break;
                  case 9 :ew=8.61;break;
                  case 19 :ew=16.46;break;
                  case 29 :ew=29.44;break;
                  case 39 :ew=54.50;break;
                  case 10 :ew=9.20;break;
                  case 20:ew=17.53;break;
                  case 30 :ew=31.80;break;
                  case 40 :ew=55.30;break;
                  default :
                  ew=55.30;
                  break;
              }
             nemdeger=nemdeger/100;
             E=(double)11*ew*(1-nemdeger)*(1+ruzgardeger/16);
             System.out.println("Aylik Buharlasma miktari : "+E);
             firebaseNesnesi.child("AylikBuharlasmamiktari").child("AylikBuharlasmamiktari").setValue(E); 
             System.out.println("Gunluk Buharlasma miktari : "+E/30);
             firebaseNesnesi.child("GunlukBuharlasmamiktari").child("GunlukBuharlasmamiktari").setValue(E/30); 
             System.out.println("saatlik Buharlasma miktari"+E/(30*24));
             firebaseNesnesi.child("saatlikBuharlasmamiktari").child("saatlikBuharlasmamiktari").setValue(E/24); 
             hesap=E/1000;
             Esaniye=hesap*katsayi*400;
             saniye=((Esaniye/(34*24*60*60))*1000);
             System.out.println("Saniyede tahmini "+saniye+" ml su buharlasacak.");
             firebaseNesnesi.child("saniyedebuharlasansu").child("saniyedebuharlasansu").setValue("Saniyede tahmini "+saniye+" ml su buharlasicak"); 
             suankadarbuharlasan=saniye+suankadarbuharlasan;
              System.out.println("suanakadar tahmini "+ suankadarbuharlasan+" ml su buharlasti");
               firebaseNesnesi.child("tahminibuharlasmissumiktari").child("tahminibuharlasmissumiktari").setValue("Simdiye kadar tahmini olarak : "+ suankadarbuharlasan+" ml su buharlasti"); 
               miktar=miktar-(suankadarbuharlasan/1000);
             System.out.println("suanda kapta "+ miktar/1000 +"litre su bulunmaktadir");
             firebaseNesnesi.child("suankaptabulunansumiktari").child("suankaptabulunansumiktari").setValue("Suanda kapta tahmini "+ (miktar/1000) +" lt su bulunmaktadir"); 
                 islem=miktar/saniye;
                 gun=saniye*60*60*24;
                 System.out.println("Bir saat sonra tahmini "+ (int)gun/24+" ml su buharlasacak");
                 firebaseNesnesi.child("birsaatsonratahminibuharlasansu").child("birsaatsonratahminibuharlasansu").setValue("Bir saat sonra tahmini "+ (int)gun/24+" ml su buharlasacak"); 
                 System.out.println("bir gun sonra tahmini "+ gun/1000+" lt su buharlasacak");
                 firebaseNesnesi.child("birgunsonratahminibuharlasansu").child("birgunsonratahminibuharlasansu").setValue("Bir gun sonra tahmini "+ gun/1000+" lt su buharlasacak"); 
                 saat=(islem/86400)-((int)islem/86400);
                 dakika=((saat*24)-(int)(saat*24))*60;;
                 System.out.println("Tahmini suyun buharlasmasi "+ (int)islem/86400 +" gun "+(int) saat*24+" saat "+(int)dakika+" dk surecek");
                 
                firebaseNesnesi.child("tahminibuharlasmasuresi").child("tahminibuharlasmasuresi").setValue("Tahmini suyun buharlasmasi "+ (int)islem/86400 +" gun "+(int) saat*24+" saat "+(int)dakika+" dk surecek"); 
             ruzgar.clear();
             }
           
           catch(Exception e){
               
           
           }
              }
             };
             myTimer.schedule(gorev,0,1000);
          
        }
       public static String getir()
       {
           try
           {
                String url="http://api.openweathermap.org/data/2.5/forecast?id=315368&APPID=f3d3fddcac184ee043e2ea0d4267dcd7";
                URL obj=new URL(url);
                HttpURLConnection con=(HttpURLConnection) obj.openConnection(); 
                con.setRequestProperty("Accept","application/vnd.kafka.json.v2+json");
                con.setRequestMethod("GET");
                int responseCode =con.getResponseCode();
                BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
                String s="";
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                  s=inputLine;
                } 
               in.close();
                JSONObject myResponse = new JSONObject(s);
                JSONArray sourceArray = new JSONArray(myResponse.get("list").toString());
                for (int i = 0; i < sourceArray.length(); i++) {
                String name=sourceArray.getJSONObject(i).get("wind").toString();
                 String tarih=sourceArray.getJSONObject(i).get("dt_txt").toString();
                 JSONObject deger = new JSONObject(name);
                  String ruzgarHizi= (String) deger.get("speed").toString();
               
                 ruzgar.add( ruzgarHizi);
                }
           }  
           catch(Exception e){
               
           }
           String donder=ruzgar.get(0);
           return donder;
           
       }

   
}
