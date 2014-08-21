package com.example.kiaan.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    String d = "default Description";
    String[] f = {"Science", "Commerce", "Humanities", "Engineering and Built Environment"};
    String[] t = {"Staff", "PostGrad", "Standard"};

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private String pollybebe = "";

    List<Building> buildings = new ArrayList<Building>();
    List<Parking> parking = new ArrayList<Parking>();
    List<Icon> pointsOfInterest = new ArrayList<Icon>(){}; //Array of Icons

    ArrayList<LatLng> markerPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);

        markerPoints = new ArrayList<LatLng>();

        //Set the camera focus to UCT

        CameraPosition cameraPos = new CameraPosition.Builder().target(new LatLng(-33.957798800000000000, 18.461580899999944000)).bearing(270).zoom(18).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPos));


        PolygonOptions rectOptions;
        Polygon polygon;

        //RW JAMES
        Building rw = new Building("R.W. James", d, f[0]);
        rw.setPolygon(mMap, new LatLng(-33.95527108805417, 18.461837768554688),new LatLng(-33.95596217066635, 18.461838774383068),new LatLng(-33.95596217066635, 18.461594693362713),new LatLng(-33.9559349168105, 18.461594693362713),new LatLng(-33.9559349168105, 18.461554795503616),new LatLng(-33.95527080995138, 18.46155244857073),new LatLng(-33.95527080995138, 18.461642302572727),new LatLng(-33.955305016587076, 18.46164297312498),new LatLng(-33.95530640710043, 18.46174020320177),new LatLng(-33.95527108805417, 18.461742214858532) );
        buildings.add(rw);

        //Molecular
        Building molecular = new Building("Molecular Biology", d, f[0]);
        molecular.setPolygon(mMap, new LatLng(-33.954969067894524, 18.461293280124664),new LatLng(-33.95548522692853, 18.46130132675171),new LatLng(-33.955483002111826, 18.461206443607807),new LatLng(-33.95553695390048, 18.461209125816822),new LatLng(-33.955539178715775, 18.461079709231853),new LatLng(-33.95563401141355, 18.46107702702284),new LatLng(-33.95564235446107, 18.46080109477043),new LatLng(-33.955138989129125, 18.460786677896976),new LatLng(-33.95513008982576, 18.46102774143219),new LatLng(-33.9550313631165, 18.46102975308895),new LatLng(-33.95502913828792, 18.461146764457226),new LatLng(-33.95497351755474, 18.46114207059145));
        buildings.add(molecular);

        //Maths
        Building maths = new Building("Maths", d, f[0]);
        maths.setPolygon(mMap, new LatLng(-33.95697667533483, 18.461483046412468),new LatLng(-33.957012271770196, 18.461769707500935),new LatLng(-33.957515626019806, 18.461687564849854),new LatLng(-33.95748225455952, 18.46139620989561));
        buildings.add(maths);

        //Computer Science
        Building cs = new Building("Computer Science", d, f[0]);
        cs.setPolygon(mMap, new LatLng(-33.95654812645575, 18.46092212945223), new LatLng(-33.95658344497192, 18.46126914024353), new LatLng(-33.95670386153494, 18.46125941723585), new LatLng(-33.95670386153494, 18.46123293042183), new LatLng(-33.95701032509053, 18.461196720600128), new LatLng(-33.957013106061474, 18.461221866309643), new LatLng(-33.95713880585348, 18.46120811998844), new LatLng(-33.957104599955024, 18.46085373312235));
        buildings.add(cs);

        //PD Hahn
        Building pd = new Building("PD Hahn", d, f[0]);
        pd.setPolygon(mMap,new LatLng(-33.956432715454234, 18.460001461207867),new LatLng(-33.956445508006695, 18.46073303371668),new LatLng(-33.956053387589805, 18.460744433104992),new LatLng(-33.95604949418653, 18.460556007921696),new LatLng(-33.95601167254548, 18.460561372339725),new LatLng(-33.95601167254548, 18.460536561906338),new LatLng(-33.955962726867405, 18.460536561906338),new LatLng(-33.95596662027465, 18.460744433104992),new LatLng(-33.95560119541865, 18.460752479732037),new LatLng(-33.955592852367076, 18.460543602705002),new LatLng(-33.95541792619752, 18.46054896712303),new LatLng(-33.955415701379046, 18.460426591336727),new LatLng(-33.95557672246506, 18.460419215261936),new LatLng(-33.95558117209352, 18.46039440482855),new LatLng(-33.955698252858426, 18.46039440482855),new LatLng(-33.955698252858426, 18.460419215261936),new LatLng(-33.95573524033499, 18.46041653305292),new LatLng(-33.95573384982864, 18.460235483944416),new LatLng(-33.95596050206318, 18.460230119526386),new LatLng(-33.95596439547053, 18.46041653305292),new LatLng(-33.956065902099105, 18.460412174463272),new LatLng(-33.956065902099105, 18.460464142262936),new LatLng(-33.956084534809555, 18.460464142262936),new LatLng(-33.95607786040628, 18.460073545575142),new LatLng(-33.95619549668727, 18.460068181157112),new LatLng(-33.95619772148534, 18.460197933018208),new LatLng(-33.956311186109936, 18.460197933018208),new LatLng(-33.95630673651966, 18.460006825625896));
        buildings.add(pd);

        //NSLT
        Building nslt = new Building("NSLT", d, f[0]);
        nslt.setPolygon(mMap, new LatLng(-33.955880130971806, 18.461298644542694),new LatLng(-33.95566960841063, 18.461298644542694),new LatLng(-33.955668496004705, 18.461025394499302),new LatLng(-33.955709655014566, 18.461025394499302),new LatLng(-33.955709655014566, 18.460954651236534),new LatLng(-33.95584314355822, 18.460954651236534),new LatLng(-33.95584314355822, 18.46102673560381),new LatLng(-33.95588040907259, 18.461026065051556));
        buildings.add(nslt);

        //Hoeri
        Building hoeri = new Building("Hoerikwaggo", d, f[3]);
        hoeri.setPolygon(mMap, new LatLng(-33.956504743061494, 18.46017077565193),new LatLng(-33.956517535603126, 18.460326343774796),new LatLng(-33.956825946513774, 18.46029281616211),new LatLng(-33.95681649119137, 18.460174798965454),new LatLng(-33.956874335500196, 18.460166081786156),new LatLng(-33.956865714475896, 18.460061475634575),new LatLng(-33.95685375627945, 18.460061475634575),new LatLng(-33.95684430096014, 18.459926024079323),new LatLng(-33.956730837046486, 18.459938764572144),new LatLng(-33.956735008516574, 18.459991738200188),new LatLng(-33.95661542629281, 18.46000414341688),new LatLng(-33.956607917635935, 18.45991227775812),new LatLng(-33.9565453454696, 18.459918648004532),new LatLng(-33.9565636999765, 18.46016474068165));
        buildings.add(hoeri);

        //GEO
        Building geo = new Building("Geological Sciences", d, f[0]);
        geo.setPolygon(mMap, new LatLng(-33.95880570102158, 18.460349813103676),new LatLng(-33.95884268714727, 18.46049264073372),new LatLng(-33.95890692616946, 18.46046917140484),new LatLng(-33.95892249925844, 18.460527509450912),new LatLng(-33.958853254608805, 18.460556343197823),new LatLng(-33.95889552444179, 18.460720293223858),new LatLng(-33.95910993228437, 18.46063781529665),new LatLng(-33.95906655019641, 18.460472859442234),new LatLng(-33.958977005047444, 18.4605073928833),new LatLng(-33.95896059769627, 18.460444025695324),new LatLng(-33.959045137234575, 18.46040915697813),new LatLng(-33.9590081511969, 18.460270017385483));
        buildings.add(geo);

        //EM
        Building em = new Building("Electrical Mechanical", d, f[3]);
        em.setPolygon(mMap, new LatLng(-33.95823060641206, 18.46060059964657),new LatLng(-33.95830902863318, 18.46093386411667),new LatLng(-33.95842388090456, 18.460898995399475),new LatLng(-33.95842026570226, 18.46087921410799),new LatLng(-33.95872922589867, 18.460769578814507),new LatLng(-33.958733675362254, 18.46079170703888),new LatLng(-33.958839071962764, 18.46075415611267),new LatLng(-33.958762596869846, 18.460419215261936));
        buildings.add(em);

        //Snape
        Building snape = new Building("Snape", d, f[3]);
        snape.setPolygon(mMap, new LatLng(-33.959014547279764, 18.459251448512077),new LatLng(-33.958980342135426, 18.45909621566534),new LatLng(-33.958958651061174, 18.459101915359497),new LatLng(-33.958930841983516, 18.45897551625967),new LatLng(-33.95874396474589, 18.459034860134125),new LatLng(-33.95875759122501, 18.459100909531116),new LatLng(-33.958682228425396, 18.459125719964504),new LatLng(-33.95867110475929, 18.459072411060333),new LatLng(-33.95833739409961, 18.459179028868675),new LatLng(-33.958355192034496, 18.459263183176517),new LatLng(-33.9583251580172, 18.45927458256483),new LatLng(-33.95836742811259, 18.459459990262985));
        buildings.add(snape);

        //Engineering
        Building eng = new Building("Chemical Engineering", d, f[3]);
        eng.setPolygon(mMap, new LatLng(-33.958292343060265, 18.459480106830597), new LatLng(-33.95780540098302, 18.459671214222908), new LatLng(-33.95773949256081, 18.459474742412567), new LatLng(-33.95775645633681, 18.459462337195873), new LatLng(-33.95775645633681, 18.459422774612904), new LatLng(-33.958226435015284, 18.45923099666834));
        buildings.add(eng);

        // Menzies
        Building men = new Building("Menzies", d, f[3]);
        men.setPolygon(mMap, new LatLng(-33.958911097532855, 18.45988143235445), new LatLng(-33.9587845660854, 18.459922671318054), new LatLng(-33.95878845936351, 18.459938764572144), new LatLng(-33.95860992456967, 18.459998108446598), new LatLng(-33.95860464082396, 18.459983356297016), new LatLng(-33.95839940876289, 18.460051752626896), new LatLng(-33.95843750743495, 18.460229448974133), new LatLng(-33.95875564458527, 18.460129871964455), new LatLng(-33.95894724934042, 18.460045382380486));
        buildings.add(men);

        //EGS
        Building egs = new Building("Environmental & Geographical Sceiences", d, f[3]);
        egs.setPolygon(mMap, new LatLng(-33.95733013615387, 18.459700047969818), new LatLng(-33.957351827643336, 18.459880091249943), new LatLng(-33.95732485232868, 18.459885455667973), new LatLng(-33.9573621171941, 18.460189551115036), new LatLng(-33.957086801758514, 18.460236825048923), new LatLng(-33.95705454251785, 18.45997329801321), new LatLng(-33.95702478613847, 18.45997966825962), new LatLng(-33.956997532622985, 18.4597597271204), new LatLng(-33.95705648919652, 18.459747321903706), new LatLng(-33.95705537680871, 18.45972016453743), new LatLng(-33.95723085580462, 18.45968931913376), new LatLng(-33.95723697392473, 18.459715135395527));
        buildings.add(egs);

        //Arts
        Building arts = new Building("Arts Block", d, f[2]);
        arts.setPolygon(mMap, new LatLng(-33.958049845697985, 18.46127785742283), new LatLng(-33.958107689168266, 18.461555130779743), new LatLng(-33.95859462951539, 18.461407274007797), new LatLng(-33.95853567400771, 18.46113134175539));
        buildings.add(arts);

        //Beattie
        Building beattie = new Building("Beattie", d, f[2]);
        beattie.setPolygon(mMap, new LatLng(-33.95871254040817, 18.46106629818678), new LatLng(-33.95878484417669, 18.461343236267567), new LatLng(-33.959332682272276, 18.461139053106308), new LatLng(-33.959261213238584, 18.46086211502552));
        buildings.add(beattie);

        //HGS
        Building hgs = new Building("Humanities", d, f[2]);
        hgs.setPolygon(mMap, new LatLng(-33.96025843720902, 18.460064493119717), new LatLng(-33.96017389887639, 18.46011444926262), new LatLng(-33.96016194114492, 18.46009500324726), new LatLng(-33.960025678504884, 18.46017614006996), new LatLng(-33.96002122910887, 18.460199609398842), new LatLng(-33.95994113994094, 18.460248559713364), new LatLng(-33.95989970489044, 18.46015401184559), new LatLng(-33.95990776943204, 18.460146635770798), new LatLng(-33.959860216434265, 18.460029624402523), new LatLng(-33.959868559067374, 18.460019901394844), new LatLng(-33.959864665838694, 18.460004813969135), new LatLng(-33.959852151888136, 18.460015542805195), new LatLng(-33.95981739090474, 18.45992535352707), new LatLng(-33.959866890540816, 18.459890484809875), new LatLng(-33.9598196156081, 18.459774143993855), new LatLng(-33.96000482195909, 18.459661826491356), new LatLng(-33.96005682427041, 18.45978856086731), new LatLng(-33.96013079541786, 18.459743969142437));
        buildings.add(hgs);

        //Centlivres
        Building cent = new Building("Centlivres", d, f[3]);
        cent.setPolygon(mMap, new LatLng(-33.95943168207968, 18.46078298985958), new LatLng(-33.95952651043888, 18.461060263216496), new LatLng(-33.95960799044021, 18.46101935952902), new LatLng(-33.95958546525993, 18.460953645408154), new LatLng(-33.95965304078286, 18.46091877669096), new LatLng(-33.95967500976846, 18.460979461669922), new LatLng(-33.959973119999674, 18.460830599069595), new LatLng(-33.95994948256611, 18.460762202739716), new LatLng(-33.96002373189415, 18.460724651813507), new LatLng(-33.96004848165576, 18.46079707145691), new LatLng(-33.96013107350476, 18.460754491388798), new LatLng(-33.960039304778704, 18.460482247173786), new LatLng(-33.95996088415254, 18.460520803928375), new LatLng(-33.95998146262172, 18.460582830011845), new LatLng(-33.95991750249849, 18.460615016520023), new LatLng(-33.95989692401384, 18.46055433154106), new LatLng(-33.959592695565355, 18.460703529417515), new LatLng(-33.95960326293373, 18.460737392306328), new LatLng(-33.95958768996936, 18.460747450590134), new LatLng(-33.95959686689514, 18.460777290165424), new LatLng(-33.95954653283552, 18.4608044475317), new LatLng(-33.959523729550085, 18.46073605120182));
        buildings.add(cent);

        //LC
        Building lc = new Building("Leslie Commerce", d, f[1]);
        lc.setPolygon(mMap, new LatLng(-33.959594642185955, 18.459717482328415), new LatLng(-33.959058763665446, 18.459989055991173), new LatLng(-33.958980064044766, 18.459760397672653), new LatLng(-33.95910603902098, 18.459698036313057), new LatLng(-33.95910993228437, 18.4597148001194), new LatLng(-33.959409434941996, 18.459565602242947), new LatLng(-33.95940498551375, 18.459548838436604), new LatLng(-33.95951677732771, 18.459496200084686));
        buildings.add(lc);

        //LS
        Building ls = new Building("Leslie Social", d, f[1]);
        ls.setPolygon(mMap, new LatLng(-33.95979152872387, 18.46028745174408), new LatLng(-33.95924897728904, 18.460558019578457), new LatLng(-33.959086016520665, 18.460093326866627), new LatLng(-33.95926315986675, 18.46000414341688), new LatLng(-33.95934769910441, 18.460252583026886), new LatLng(-33.9595209486612, 18.46016574651003), new LatLng(-33.95943640959571, 18.45991227775812), new LatLng(-33.95962856899475, 18.45981203019619));
        buildings.add(ls);

        //Botany
        Building bot = new Building("Botony", d, f[0]);
        bot.setPolygon(mMap, new LatLng(-33.95613097751783, 18.461559154093266), new LatLng(-33.95614154531617, 18.461835086345673), new LatLng(-33.95623415254551, 18.461825363337994), new LatLng(-33.95623415254551, 18.461755625903606), new LatLng(-33.95631480140185, 18.461750261485577), new LatLng(-33.956318694792984, 18.461802899837494), new LatLng(-33.95679535576104, 18.46177238970995), new LatLng(-33.956781172771954, 18.461514227092266), new LatLng(-33.95630451172444, 18.461546413600445), new LatLng(-33.95630590222146, 18.461628556251526), new LatLng(-33.956226087655665, 18.461635932326317), new LatLng(-33.95622386285834, 18.46155647188425));
        buildings.add(bot);

        //ZOO
        Building zoo = new Building("John Day Zoology", d, f[0]);
        zoo.setPolygon(mMap, new LatLng(-33.955932692005554, 18.460945934057236),new LatLng(-33.9559349168105, 18.461136370897293),new LatLng(-33.95597524139004, 18.461135029792786),new LatLng(-33.95597607569149, 18.46118364483118),new LatLng(-33.95596578597311, 18.461182303726673),new LatLng(-33.95596689837515, 18.461285568773746),new LatLng(-33.95619994628334, 18.46127651631832),new LatLng(-33.95619688718606, 18.461164869368076),new LatLng(-33.956293943946335, 18.461159840226173),new LatLng(-33.956297003040135, 18.46127148717642),new LatLng(-33.95650808024646, 18.461263440549374),new LatLng(-33.956503908765235, 18.461151458323002),new LatLng(-33.95652587856402, 18.461151458323002),new LatLng(-33.95651225172747, 18.460949957370758),new LatLng(-33.95644634230353, 18.460952639579773),new LatLng(-33.95644522990774, 18.46093889325857),new LatLng(-33.956039482577296, 18.460953310132027),new LatLng(-33.956039482577296, 18.46094224601984));
        buildings.add(zoo);



        //SportsCentre1
        Parking sc1 = new Parking("Sports Centre PG", d, t[1]);
        sc1.setPolygon(mMap, new LatLng(-33.955934638709884, 18.46337165683508), new LatLng(-33.95616129040956, 18.4636452421546), new LatLng(-33.95554640936507, 18.463555723428726), new LatLng(-33.95515511911413, 18.46374347805977), new LatLng(-33.95502607914854, 18.46345581114292), new LatLng(-33.95573162501845, 18.463391438126564), new LatLng(-33.95574052425891, 18.463436029851437));
        parking.add(sc1);

        //SportsCentre2
        Parking sc2 = new Parking("Sports Centre S", d, t[2]);
        sc2.setPolygon(mMap, new LatLng(-33.95500855862089, 18.463048450648785),new LatLng(-33.95501745793698, 18.463447093963623),new LatLng(-33.955156787733095, 18.4637401252985),new LatLng(-33.95455969815839, 18.464108258485794),new LatLng(-33.954353622022865, 18.46385981887579),new LatLng(-33.95427936774645, 18.463581204414368),new LatLng(-33.95428242691268, 18.46330761909485),new LatLng(-33.954679561376075, 18.463148698210716),new LatLng(-33.95499215050441, 18.463069908320904));
        parking.add(sc2);

        //North
        Parking north = new Parking("North", d, t[2]);
        north.setPolygon(mMap,new LatLng(-33.955472712333815, 18.46228938549757),new LatLng(-33.95539011596255, 18.462525084614754),new LatLng(-33.95530696330576, 18.462559282779694),new LatLng(-33.95511284742281, 18.462511003017426),new LatLng(-33.95491150039438, 18.462535813450813),new LatLng(-33.954828347269874, 18.462514355778694),new LatLng(-33.95475882118366, 18.462449982762337),new LatLng(-33.95464757932755, 18.46227664500475),new LatLng(-33.95461365053249, 18.46192829310894),new LatLng(-33.954655088157416, 18.461783453822136),new LatLng(-33.954763270854876, 18.461590334773064),new LatLng(-33.954775229345124, 18.461345583200455),new LatLng(-33.954828347269874, 18.461300991475582),new LatLng(-33.95488619293031, 18.4612724930048),new LatLng(-33.955018014144194, 18.461853191256523),new LatLng(-33.95506696036572, 18.461978249251842),new LatLng(-33.955096717429804, 18.4620426222682),new LatLng(-33.95516318410547, 18.462106995284557),new LatLng(-33.9552329879642, 18.46215158700943),new LatLng(-33.95526107635334, 18.462212271988392),new LatLng(-33.955471599925296, 18.462291061878204));
        parking.add(north);

        //South
        Parking south = new Parking("South", d, t[2]);
        south.setPolygon(mMap, new LatLng(-33.960525399813214, 18.460509404540062),new LatLng(-33.959845477780426, 18.46146896481514),new LatLng(-33.959820171783925, 18.4615296497941),new LatLng(-33.959803764595364, 18.461608439683914),new LatLng(-33.95981572237718, 18.461663760244846),new LatLng(-33.95982907059675, 18.46169762313366),new LatLng(-33.959852708063764, 18.461733497679234),new LatLng(-33.95988246345408, 18.461758643388748),new LatLng(-33.959931406877196, 18.461772724986076),new LatLng(-33.9599653335517, 18.461772724986076),new LatLng(-33.96002623467937, 18.461772724986076),new LatLng(-33.960084076805906, 18.46174255013466),new LatLng(-33.96014609019598, 18.46169762313366),new LatLng(-33.96019197451378, 18.46164397895336),new LatLng(-33.960236468374084, 18.46157994121313),new LatLng(-33.960278181346986, 18.461524285376072),new LatLng(-33.96029875973941, 18.46146896481514),new LatLng(-33.96034464397488, 18.461399227380753),new LatLng(-33.960389137755335, 18.461281210184097),new LatLng(-33.960418892958025, 18.46113134175539),new LatLng(-33.96044697963514, 18.461022041738033),new LatLng(-33.960480906104024, 18.460958003997803),new LatLng(-33.960541806862594, 18.460882902145386),new LatLng(-33.96059519927261, 18.46080243587494),new LatLng(-33.960690026334866, 18.46069883555174),new LatLng(-33.9607656654407, 18.460618369281292),new LatLng(-33.9608262879108, 18.460548631846905),new LatLng(-33.960867722509995, 18.460450395941734),new LatLng(-33.960884129493365, 18.460344783961773),new LatLng(-33.960851593608005, 18.460280410945415),new LatLng(-33.96080988091627, 18.460246548056602),new LatLng(-33.960719503347335, 18.460250236093998),new LatLng(-33.96060409800435, 18.46041988581419));
        parking.add(south);

        //Ring1
        Parking ring1 = new Parking("Ring Staff", d, t[0]);
        ring1.setPolygon(mMap, new LatLng(-33.96081822345625, 18.45984388142824),new LatLng(-33.960950035479414, 18.459500558674335),new LatLng(-33.960995919363604, 18.459540121257305),new LatLng(-33.96102873327772, 18.459559567272663),new LatLng(-33.96108184729834, 18.459570296108723),new LatLng(-33.96114413804465, 18.459570296108723),new LatLng(-33.961169443647314, 18.459559567272663),new LatLng(-33.96109074597918, 18.459977991878986),new LatLng(-33.96104180322304, 18.45996357500553),new LatLng(-33.960984239831795, 18.459927700459957),new LatLng(-33.960843529155866, 18.459852933883667));

        //Ring2
        Parking ring2 = new Parking("Ring S", d, t[2]);
        ring2.setPolygon(mMap, new LatLng(-33.96094947931097, 18.459498211741447),new LatLng(-33.96091249410121, 18.459463343024254),new LatLng(-33.96088802267539, 18.45943920314312),new LatLng(-33.96086521974954, 18.45941137522459),new LatLng(-33.96085103743892, 18.459386564791203),new LatLng(-33.96084658808607, 18.45937918871641),new LatLng(-33.96062578865907, 18.459623269736767),new LatLng(-33.9606533190975, 18.4596698731184),new LatLng(-33.96069169484527, 18.459725193679333),new LatLng(-33.96072506504667, 18.459760062396526),new LatLng(-33.960768168204076, 18.45979928970337),new LatLng(-33.96081989196416, 18.459839522838593));

        //Nursery1
        Parking nurse1 = new Parking("Nursery Middle", d, t[1]);
        nurse1.setPolygon(mMap, new LatLng(-33.95847421562839, 18.45845751464367),new LatLng(-33.95851120189819, 18.458630852401257),new LatLng(-33.958951420701844, 18.458387777209282),new LatLng(-33.95902261190528, 18.458382412791252),new LatLng(-33.95970698992724, 18.458273448050022),new LatLng(-33.959661105347855, 18.458084017038345),new LatLng(-33.95949675492406, 18.45811787992716),new LatLng(-33.959203370552565, 18.458143025636673),new LatLng(-33.959046249596355, 18.458168171346188),new LatLng(-33.95848172412055, 18.458346873521805),new LatLng(-33.95844028835925, 18.458371683955193));

        //Nursery2
        Parking nurse2 = new Parking("Nursery Top", d, t[1]);
        nurse2.setPolygon(mMap, new LatLng(-33.95834796162389, 18.45815509557724),new LatLng(-33.95773754589779, 18.45844980329275),new LatLng(-33.95772558782389, 18.45844443887472),new LatLng(-33.957688601212546, 18.45843907445669),new LatLng(-33.95766802218876, 18.458469584584236),new LatLng(-33.9576721936129, 18.45850009471178),new LatLng(-33.957693050730555, 18.45851417630911),new LatLng(-33.95773003733996, 18.45850344747305),new LatLng(-33.95774199541323, 18.45847863703966),new LatLng(-33.95835241110743, 18.458215780556202));

        //Nursery3
        Parking nurse3 = new Parking("Nursery Bottom", d, t[1]);
        nurse3.setPolygon(mMap, new LatLng(-33.95836742811259, 18.4588460996747),new LatLng(-33.95673139324251, 18.459543138742447),new LatLng(-33.95674919151337, 18.45959309488535),new LatLng(-33.95670775490827, 18.459610864520073),new LatLng(-33.95664267993069, 18.459610864520073),new LatLng(-33.956609864324825, 18.45959309488535),new LatLng(-33.95659234412329, 18.459532409906387),new LatLng(-33.95657732680481, 18.459482118487358),new LatLng(-33.956600965175284, 18.459414392709732),new LatLng(-33.956657419139376, 18.45935370773077),new LatLng(-33.95670775490827, 18.45935370773077),new LatLng(-33.95679952722797, 18.45932487398386),new LatLng(-33.95836742811259, 18.458645939826965));

        //Eng Mall
        Parking engMall = new Parking("Engineering Mall", d, t[0]);
        engMall.setPolygon(mMap, new LatLng(-33.95980320841942, 18.45909621566534),new LatLng(-33.95979125063586, 18.459185734391212),new LatLng(-33.959126061516564, 18.45943048596382),new LatLng(-33.95907266818451, 18.459475077688694),new LatLng(-33.95901037592144, 18.45964305102825),new LatLng(-33.95866804575085, 18.459803983569145),new LatLng(-33.958508142884, 18.45958974212408),new LatLng(-33.959035682158806, 18.459300063550472),new LatLng(-33.959047361958135, 18.459182046353817),new LatLng(-33.95902817371554, 18.45909621566534),new LatLng(-33.95961800162952, 18.459001667797565));

        //West
        Parking west = new Parking("West", d, t[0]);
        west.setPolygon(mMap, new LatLng(-33.95980320841942, 18.45909621566534),new LatLng(-33.95979125063586, 18.459185734391212),new LatLng(-33.959126061516564, 18.45943048596382),new LatLng(-33.95907266818451, 18.459475077688694),new LatLng(-33.95901037592144, 18.45964305102825),new LatLng(-33.95866804575085, 18.459803983569145),new LatLng(-33.958508142884, 18.45958974212408),new LatLng(-33.959035682158806, 18.459300063550472),new LatLng(-33.959047361958135, 18.459182046353817),new LatLng(-33.95902817371554, 18.45909621566534),new LatLng(-33.95961800162952, 18.459001667797565));

        //SteveBiko
        Parking steveBiko = new Parking("Steve Biko", d, t[0]);
        steveBiko.setPolygon(mMap, new LatLng(-33.95654117399021, 18.459919653832912),new LatLng(-33.956559528498005, 18.460153676569462),new LatLng(-33.95650196207393, 18.46016339957714),new LatLng(-33.95651447651726, 18.460325337946415),new LatLng(-33.95682566841608, 18.460297510027885),new LatLng(-33.95683456754211, 18.46029046922922),new LatLng(-33.95683011797921, 18.460335060954094),new LatLng(-33.956555913216484, 18.460385017096996),new LatLng(-33.956555913216484, 18.46042189747095),new LatLng(-33.9565723210314, 18.460439667105675),new LatLng(-33.95658261067643, 18.460544273257256),new LatLng(-33.95644856709505, 18.460576459765434),new LatLng(-33.95643605264202, 18.4599669277668));

        //MolecularNorth
        Parking molNorth = new Parking("Molecular Biology North", d, t[0]);
        molNorth.setPolygon(mMap, new LatLng(-33.9551384329227, 18.460768572986126),new LatLng(-33.9551384329227, 18.460809476673603),new LatLng(-33.95484503352211, 18.460798747837543),new LatLng(-33.95482111655956, 18.46074879169464));

        //MolecularSouth
        Parking molSouth = new Parking("Molecular Biology South", d, t[0]);
        molSouth.setPolygon(mMap, new LatLng(-33.95645663196379, 18.460711240768433),new LatLng(-33.95651447651726, 18.460711240768433),new LatLng(-33.95651447651726, 18.460814841091633),new LatLng(-33.955689075512126, 18.460820205509663),new LatLng(-33.955689075512126, 18.4607595205307),new LatLng(-33.95645663196379, 18.460734374821186),new LatLng(-33.956465531128416, 18.460714928805828));

        //PD Hahn Bottom
        Parking pdBottom = new Parking("PD Hahn Bottom", d, t[1]);
        pdBottom.setPolygon(mMap, new LatLng(-33.95479914632058, 18.460678718984127),new LatLng(-33.95554696556885, 18.460730016231537),new LatLng(-33.95554919038387, 18.460719287395477),new LatLng(-33.95554084732721, 18.460702188313007),new LatLng(-33.95552026778394, 18.460684418678284),new LatLng(-33.955485505030616, 18.460667319595814),new LatLng(-33.955417091890595, 18.460620045661926),new LatLng(-33.95538232909512, 18.460620045661926),new LatLng(-33.955343116644784, 18.460629768669605),new LatLng(-33.955303904176375, 18.460629768669605),new LatLng(-33.95526469168989, 18.460629768669605),new LatLng(-33.95522520108239, 18.460615687072277),new LatLng(-33.95517347392093, 18.460602946579456),new LatLng(-33.955134817580785, 18.460587859153748),new LatLng(-33.955077250192794, 18.460558354854584),new LatLng(-33.95503553466991, 18.46052549779415),new LatLng(-33.95505555812345, 18.460525162518024),new LatLng(-33.95499632205974, 18.46051275730133),new LatLng(-33.954921512136345, 18.460505716502666),new LatLng(-33.95485782631328, 18.46049565821886),new LatLng(-33.954822785185065, 18.460505716502666),new LatLng(-33.95479775579894, 18.46053756773472),new LatLng(-33.95477550744953, 18.460560031235218));

        /*PD Hahn Bottom
        Parking pdTop = new Parking("PD Hahn Bottom", d, t[1]);
        */

         /* Setup Icons on Map */

        //mMap.setOnMarkerDragListener(this); //For dragging for debugging




        //Post Office
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.957069281655194,18.461346924304962))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_postoffice))
        );


        //Juta Bookshop
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.956998, 18.460559))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_juta))
        );

        //CPS
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.959210044710645,18.460659943521023))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cps))

        );

        //Ridelink
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.959635, 18.462105))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_ridelink))
        );

        //Info
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.955926, 18.462393))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_info))
        );

        //Library
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.95783209805089,18.460386022925377))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_library))
                        .draggable(true)
        );

        //Jammie Stop - North
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.955156787733095,18.46179485321045))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_jammie))

        );

        //Jammie Stop - West
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.957426357334214,18.459730222821236))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_jammie))

        );

        //Jammie Stop - South
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.96041917104399,18.459826111793518))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_jammie))

        );

        //Jammie Stop - Drop Off
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.960539, 18.460524))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_jammie))
        );

        //ATMS
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.95722390339486,18.46059925854206))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_atm))

        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.959641, 18.460194))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_atm))

        );

        //Food
        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.956904, 18.460757))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.957309, 18.460972))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng( -33.955575, 18.461325))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.959835, 18.460083))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.958476, 18.460096))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.957386, 18.462298))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.955888, 18.463084))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );

        mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-33.959206, 18.460155))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_food))
        );
    }

    public void onOverlayClick(LatLng click, Building building) {
        int i;
        int j;
        List<LatLng> bounds=building.rectOptions.getPoints();
        boolean result = false;
        for (i = 0, j = bounds.size() - 1; i < bounds.size(); j = i++) {
            if ((bounds.get(i).longitude > click.longitude) != (bounds.get(j).longitude > click.longitude) &&
                    (click.latitude < (bounds.get(j).latitude - bounds.get(i).latitude) *
                            (click.longitude - bounds.get(i).longitude) / (bounds.get(j).longitude-bounds.get(i).longitude) + bounds.get(i).latitude)) {
                result = !result;
                Toast.makeText(getApplicationContext(), building.name,
                        Toast.LENGTH_SHORT).show();
                building.clicked++;
                if (building.clicked == 1)
                    filterByFaculty(building.faculty);
                else if (building.clicked ==2)
                    reset();
                //filterByFaculty(building.faculty);

            }
        }

    }

    public void filterByFaculty(String f)
    {
        for (int k=0; k < buildings.size() ; k++ ) {

            if (buildings.get(k).faculty.equals(f)==false)
                buildings.get(k).hidePolygon();

        }
    }

    public void reset()
    {
        for (int k=0; k < buildings.size() ; k++ ) {


                buildings.get(k).showPolygon();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        // Already two locations
        if (markerPoints.size() > 1) {
            markerPoints.clear();
            mMap.clear();
        }

        // Adding new item to the ArrayList
        markerPoints.add(latLng);

        // Creating MarkerOptions
        MarkerOptions options = new MarkerOptions();

        // Setting the position of the marker
        options.position(latLng);

        /**
         * For the start location, the color of marker is GREEN and
         * for the end location, the color of marker is RED.
         */
        if (markerPoints.size() == 1) {
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        } else if (markerPoints.size() == 2) {
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        }

        // Add new marker to the Google Map Android API V2
        mMap.addMarker(options);

        // Checks, whether start and end locations are captured
        if (markerPoints.size() >= 2) {
            LatLng origin = markerPoints.get(0);
            LatLng dest = markerPoints.get(1);

            // Getting URL to the Google Directions API
            String url = getDirectionsUrl(origin, dest);

            DownloadTask downloadTask = new DownloadTask();

            // Start downloading json data from Google Directions API
            downloadTask.execute(url);
        }


    }




    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&mode=walking";

        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(6);
                lineOptions.color(Color.GREEN);
            }

            // Drawing polyline in the Google Map for the i-th route
            mMap.addPolyline(lineOptions);
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {


        for (int m = 0; m<buildings.size(); m++)
        {
            onOverlayClick(latLng, buildings.get(m));
        }

    }
}
