package com.example.kiaanp.myapplication;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerDragListener {

    String d = "default Description";
    String[] f = {"Science", "Commerce", "Humanities", "Engineering and Built Environment"};

    Icon [] iconList = {}; //Array of Icons

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private String pollybebe = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);

        //Set the camera to focus on UCT and face west
        LatLng uctCoords = new LatLng(-33.957798800000000000, 18.461580899999944000);
        CameraPosition cameraPos = new CameraPosition.Builder().target(uctCoords).bearing(270).zoom(17).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPos));

        //Restrict Camera Zoom

        //Resrict Camera Boundary

        /* Draw Polygons for Buildings */
        PolygonOptions rectOptions;
        Polygon polygon;

        //RW JAMES
        Building rw = new Building("R.W. James", d, f[0]);
        rw.setPolygon(mMap, new LatLng(-33.95527108805417, 18.461837768554688),new LatLng(-33.95596217066635, 18.461838774383068),new LatLng(-33.95596217066635, 18.461594693362713),new LatLng(-33.9559349168105, 18.461594693362713),new LatLng(-33.9559349168105, 18.461554795503616),new LatLng(-33.95527080995138, 18.46155244857073),new LatLng(-33.95527080995138, 18.461642302572727),new LatLng(-33.955305016587076, 18.46164297312498),new LatLng(-33.95530640710043, 18.46174020320177),new LatLng(-33.95527108805417, 18.461742214858532) );

        //Molecular
        Building molecular = new Building("Molecular Biology", d, f[0]);
        molecular.setPolygon(mMap, new LatLng(-33.954969067894524, 18.461293280124664),new LatLng(-33.95548522692853, 18.46130132675171),new LatLng(-33.955483002111826, 18.461206443607807),new LatLng(-33.95553695390048, 18.461209125816822),new LatLng(-33.955539178715775, 18.461079709231853),new LatLng(-33.95563401141355, 18.46107702702284),new LatLng(-33.95564235446107, 18.46080109477043),new LatLng(-33.955138989129125, 18.460786677896976),new LatLng(-33.95513008982576, 18.46102774143219),new LatLng(-33.9550313631165, 18.46102975308895),new LatLng(-33.95502913828792, 18.461146764457226),new LatLng(-33.95497351755474, 18.46114207059145));

        //Maths
        Building maths = new Building("Maths", d, f[0]);
        maths.setPolygon(mMap, new LatLng(-33.95697667533483, 18.461483046412468),new LatLng(-33.957012271770196, 18.461769707500935),new LatLng(-33.957515626019806, 18.461687564849854),new LatLng(-33.95748225455952, 18.46139620989561));

        //Computer Science
        Building cs = new Building("Computer Science", d, f[0]);
        cs.setPolygon(mMap, new LatLng(-33.95654812645575, 18.46092212945223), new LatLng(-33.95658344497192, 18.46126914024353), new LatLng(-33.95670386153494, 18.46125941723585), new LatLng(-33.95670386153494, 18.46123293042183), new LatLng(-33.95701032509053, 18.461196720600128), new LatLng(-33.957013106061474, 18.461221866309643), new LatLng(-33.95713880585348, 18.46120811998844), new LatLng(-33.957104599955024, 18.46085373312235));

        //PD Hahn
        Building pd = new Building("PD Hahn", d, f[0]);
        pd.setPolygon(mMap,new LatLng(-33.956432715454234, 18.460001461207867),new LatLng(-33.956445508006695, 18.46073303371668),new LatLng(-33.956053387589805, 18.460744433104992),new LatLng(-33.95604949418653, 18.460556007921696),new LatLng(-33.95601167254548, 18.460561372339725),new LatLng(-33.95601167254548, 18.460536561906338),new LatLng(-33.955962726867405, 18.460536561906338),new LatLng(-33.95596662027465, 18.460744433104992),new LatLng(-33.95560119541865, 18.460752479732037),new LatLng(-33.955592852367076, 18.460543602705002),new LatLng(-33.95541792619752, 18.46054896712303),new LatLng(-33.955415701379046, 18.460426591336727),new LatLng(-33.95557672246506, 18.460419215261936),new LatLng(-33.95558117209352, 18.46039440482855),new LatLng(-33.955698252858426, 18.46039440482855),new LatLng(-33.955698252858426, 18.460419215261936),new LatLng(-33.95573524033499, 18.46041653305292),new LatLng(-33.95573384982864, 18.460235483944416),new LatLng(-33.95596050206318, 18.460230119526386),new LatLng(-33.95596439547053, 18.46041653305292),new LatLng(-33.956065902099105, 18.460412174463272),new LatLng(-33.956065902099105, 18.460464142262936),new LatLng(-33.956084534809555, 18.460464142262936),new LatLng(-33.95607786040628, 18.460073545575142),new LatLng(-33.95619549668727, 18.460068181157112),new LatLng(-33.95619772148534, 18.460197933018208),new LatLng(-33.956311186109936, 18.460197933018208),new LatLng(-33.95630673651966, 18.460006825625896));

        //NSLT
        Building nslt = new Building("NSLT", d, f[0]);
        nslt.setPolygon(mMap, new LatLng(-33.955880130971806, 18.461298644542694),new LatLng(-33.95566960841063, 18.461298644542694),new LatLng(-33.955668496004705, 18.461025394499302),new LatLng(-33.955709655014566, 18.461025394499302),new LatLng(-33.955709655014566, 18.460954651236534),new LatLng(-33.95584314355822, 18.460954651236534),new LatLng(-33.95584314355822, 18.46102673560381),new LatLng(-33.95588040907259, 18.461026065051556));

        //Hoeri
        Building hoeri = new Building("Hoerikwaggo", d, f[0]);
        hoeri.setPolygon(mMap, new LatLng(-33.956504743061494, 18.46017077565193),new LatLng(-33.956517535603126, 18.460326343774796),new LatLng(-33.956825946513774, 18.46029281616211),new LatLng(-33.95681649119137, 18.460174798965454),new LatLng(-33.956874335500196, 18.460166081786156),new LatLng(-33.956865714475896, 18.460061475634575),new LatLng(-33.95685375627945, 18.460061475634575),new LatLng(-33.95684430096014, 18.459926024079323),new LatLng(-33.956730837046486, 18.459938764572144),new LatLng(-33.956735008516574, 18.459991738200188),new LatLng(-33.95661542629281, 18.46000414341688),new LatLng(-33.956607917635935, 18.45991227775812),new LatLng(-33.9565453454696, 18.459918648004532),new LatLng(-33.9565636999765, 18.46016474068165));

        //GEO
        Building geo = new Building("Geological Sciences", d, f[0]);
        geo.setPolygon(mMap, new LatLng(-33.95880570102158, 18.460349813103676),new LatLng(-33.95884268714727, 18.46049264073372),new LatLng(-33.95890692616946, 18.46046917140484),new LatLng(-33.95892249925844, 18.460527509450912),new LatLng(-33.958853254608805, 18.460556343197823),new LatLng(-33.95889552444179, 18.460720293223858),new LatLng(-33.95910993228437, 18.46063781529665),new LatLng(-33.95906655019641, 18.460472859442234),new LatLng(-33.958977005047444, 18.4605073928833),new LatLng(-33.95896059769627, 18.460444025695324),new LatLng(-33.959045137234575, 18.46040915697813),new LatLng(-33.9590081511969, 18.460270017385483));

        //EM
        Building em = new Building("Electrical Mechanical", d, f[3]);
        em.setPolygon(mMap, new LatLng(-33.95823060641206, 18.46060059964657),new LatLng(-33.95830902863318, 18.46093386411667),new LatLng(-33.95842388090456, 18.460898995399475),new LatLng(-33.95842026570226, 18.46087921410799),new LatLng(-33.95872922589867, 18.460769578814507),new LatLng(-33.958733675362254, 18.46079170703888),new LatLng(-33.958839071962764, 18.46075415611267),new LatLng(-33.958762596869846, 18.460419215261936));

        //Snape
        Building snape = new Building("Snape", d, f[3]);
        snape.setPolygon(mMap, new LatLng(-33.959014547279764, 18.459251448512077),new LatLng(-33.958980342135426, 18.45909621566534),new LatLng(-33.958958651061174, 18.459101915359497),new LatLng(-33.958930841983516, 18.45897551625967),new LatLng(-33.95874396474589, 18.459034860134125),new LatLng(-33.95875759122501, 18.459100909531116),new LatLng(-33.958682228425396, 18.459125719964504),new LatLng(-33.95867110475929, 18.459072411060333),new LatLng(-33.95833739409961, 18.459179028868675),new LatLng(-33.958355192034496, 18.459263183176517),new LatLng(-33.9583251580172, 18.45927458256483),new LatLng(-33.95836742811259, 18.459459990262985));

        //Engineering
        Building eng = new Building("Chemical Engineering", d, f[3]);
        eng.setPolygon(mMap, new LatLng(-33.958292343060265, 18.459480106830597), new LatLng(-33.95780540098302, 18.459671214222908), new LatLng(-33.95773949256081, 18.459474742412567), new LatLng(-33.95775645633681, 18.459462337195873), new LatLng(-33.95775645633681, 18.459422774612904), new LatLng(-33.958226435015284, 18.45923099666834));

        // Menzies
        Building men = new Building("Menzies", d, f[3]);
        men.setPolygon(mMap, new LatLng(-33.958911097532855, 18.45988143235445), new LatLng(-33.9587845660854, 18.459922671318054), new LatLng(-33.95878845936351, 18.459938764572144), new LatLng(-33.95860992456967, 18.459998108446598), new LatLng(-33.95860464082396, 18.459983356297016), new LatLng(-33.95839940876289, 18.460051752626896), new LatLng(-33.95843750743495, 18.460229448974133), new LatLng(-33.95875564458527, 18.460129871964455), new LatLng(-33.95894724934042, 18.460045382380486));

        //EGS
        Building egs = new Building("Environmental & Geographical Sceiences", d, f[3]);
        egs.setPolygon(mMap, new LatLng(-33.95733013615387, 18.459700047969818), new LatLng(-33.957351827643336, 18.459880091249943), new LatLng(-33.95732485232868, 18.459885455667973), new LatLng(-33.9573621171941, 18.460189551115036), new LatLng(-33.957086801758514, 18.460236825048923), new LatLng(-33.95705454251785, 18.45997329801321), new LatLng(-33.95702478613847, 18.45997966825962), new LatLng(-33.956997532622985, 18.4597597271204), new LatLng(-33.95705648919652, 18.459747321903706), new LatLng(-33.95705537680871, 18.45972016453743), new LatLng(-33.95723085580462, 18.45968931913376), new LatLng(-33.95723697392473, 18.459715135395527));

        //Arts
        Building arts = new Building("Arts Block", d, f[2]);
        arts.setPolygon(mMap, new LatLng(-33.958049845697985, 18.46127785742283), new LatLng(-33.958107689168266, 18.461555130779743), new LatLng(-33.95859462951539, 18.461407274007797), new LatLng(-33.95853567400771, 18.46113134175539));

        //Beattie
        Building beattie = new Building("Beattie", d, f[2]);
        beattie.setPolygon(mMap, new LatLng(-33.95871254040817, 18.46106629818678), new LatLng(-33.95878484417669, 18.461343236267567), new LatLng(-33.959332682272276, 18.461139053106308), new LatLng(-33.959261213238584, 18.46086211502552));

        //HGS
        Building hgs = new Building("Humanities", d, f[2]);
        hgs.setPolygon(mMap, new LatLng(-33.96025843720902, 18.460064493119717), new LatLng(-33.96017389887639, 18.46011444926262), new LatLng(-33.96016194114492, 18.46009500324726), new LatLng(-33.960025678504884, 18.46017614006996), new LatLng(-33.96002122910887, 18.460199609398842), new LatLng(-33.95994113994094, 18.460248559713364), new LatLng(-33.95989970489044, 18.46015401184559), new LatLng(-33.95990776943204, 18.460146635770798), new LatLng(-33.959860216434265, 18.460029624402523), new LatLng(-33.959868559067374, 18.460019901394844), new LatLng(-33.959864665838694, 18.460004813969135), new LatLng(-33.959852151888136, 18.460015542805195), new LatLng(-33.95981739090474, 18.45992535352707), new LatLng(-33.959866890540816, 18.459890484809875), new LatLng(-33.9598196156081, 18.459774143993855), new LatLng(-33.96000482195909, 18.459661826491356), new LatLng(-33.96005682427041, 18.45978856086731), new LatLng(-33.96013079541786, 18.459743969142437));

        //Centlivres
        Building cent = new Building("Centlivres", d, f[3]);
        cent.setPolygon(mMap, new LatLng(-33.95943168207968, 18.46078298985958), new LatLng(-33.95952651043888, 18.461060263216496), new LatLng(-33.95960799044021, 18.46101935952902), new LatLng(-33.95958546525993, 18.460953645408154), new LatLng(-33.95965304078286, 18.46091877669096), new LatLng(-33.95967500976846, 18.460979461669922), new LatLng(-33.959973119999674, 18.460830599069595), new LatLng(-33.95994948256611, 18.460762202739716), new LatLng(-33.96002373189415, 18.460724651813507), new LatLng(-33.96004848165576, 18.46079707145691), new LatLng(-33.96013107350476, 18.460754491388798), new LatLng(-33.960039304778704, 18.460482247173786), new LatLng(-33.95996088415254, 18.460520803928375), new LatLng(-33.95998146262172, 18.460582830011845), new LatLng(-33.95991750249849, 18.460615016520023), new LatLng(-33.95989692401384, 18.46055433154106), new LatLng(-33.959592695565355, 18.460703529417515), new LatLng(-33.95960326293373, 18.460737392306328), new LatLng(-33.95958768996936, 18.460747450590134), new LatLng(-33.95959686689514, 18.460777290165424), new LatLng(-33.95954653283552, 18.4608044475317), new LatLng(-33.959523729550085, 18.46073605120182));

        //LC
        Building lc = new Building("Leslie Commerce", d, f[1]);
        lc.setPolygon(mMap, new LatLng(-33.959594642185955, 18.459717482328415), new LatLng(-33.959058763665446, 18.459989055991173), new LatLng(-33.958980064044766, 18.459760397672653), new LatLng(-33.95910603902098, 18.459698036313057), new LatLng(-33.95910993228437, 18.4597148001194), new LatLng(-33.959409434941996, 18.459565602242947), new LatLng(-33.95940498551375, 18.459548838436604), new LatLng(-33.95951677732771, 18.459496200084686));

        //LS
        Building ls = new Building("Leslie Social", d, f[1]);
        ls.setPolygon(mMap, new LatLng(-33.95979152872387, 18.46028745174408), new LatLng(-33.95924897728904, 18.460558019578457), new LatLng(-33.959086016520665, 18.460093326866627), new LatLng(-33.95926315986675, 18.46000414341688), new LatLng(-33.95934769910441, 18.460252583026886), new LatLng(-33.9595209486612, 18.46016574651003), new LatLng(-33.95943640959571, 18.45991227775812), new LatLng(-33.95962856899475, 18.45981203019619));

        //Botany
        rectOptions = new PolygonOptions()
                .add(new LatLng(-33.95613097751783, 18.461559154093266),new LatLng(-33.95614154531617, 18.461835086345673),new LatLng(-33.95623415254551, 18.461825363337994),new LatLng(-33.95623415254551, 18.461755625903606),new LatLng(-33.95631480140185, 18.461750261485577),new LatLng(-33.956318694792984, 18.461802899837494),new LatLng(-33.95679535576104, 18.46177238970995),new LatLng(-33.956781172771954, 18.461514227092266),new LatLng(-33.95630451172444, 18.461546413600445),new LatLng(-33.95630590222146, 18.461628556251526),new LatLng(-33.956226087655665, 18.461635932326317),new LatLng(-33.95622386285834, 18.46155647188425)).fillColor(Color.MAGENTA).strokeWidth(0);
        polygon = mMap.addPolygon(rectOptions);

        Building bot = new Building("Botony", d, f[0]);
        bot.setPolygon(mMap, new LatLng(-33.95613097751783, 18.461559154093266), new LatLng(-33.95614154531617, 18.461835086345673), new LatLng(-33.95623415254551, 18.461825363337994), new LatLng(-33.95623415254551, 18.461755625903606), new LatLng(-33.95631480140185, 18.461750261485577), new LatLng(-33.956318694792984, 18.461802899837494), new LatLng(-33.95679535576104, 18.46177238970995), new LatLng(-33.956781172771954, 18.461514227092266), new LatLng(-33.95630451172444, 18.461546413600445), new LatLng(-33.95630590222146, 18.461628556251526), new LatLng(-33.956226087655665, 18.461635932326317), new LatLng(-33.95622386285834, 18.46155647188425));

        //ZOO
        Building zoo = new Building("John Day Zoology", d, f[0]);
        zoo.setPolygon(mMap, new LatLng(-33.955932692005554, 18.460945934057236),new LatLng(-33.9559349168105, 18.461136370897293),new LatLng(-33.95597524139004, 18.461135029792786),new LatLng(-33.95597607569149, 18.46118364483118),new LatLng(-33.95596578597311, 18.461182303726673),new LatLng(-33.95596689837515, 18.461285568773746),new LatLng(-33.95619994628334, 18.46127651631832),new LatLng(-33.95619688718606, 18.461164869368076),new LatLng(-33.956293943946335, 18.461159840226173),new LatLng(-33.956297003040135, 18.46127148717642),new LatLng(-33.95650808024646, 18.461263440549374),new LatLng(-33.956503908765235, 18.461151458323002),new LatLng(-33.95652587856402, 18.461151458323002),new LatLng(-33.95651225172747, 18.460949957370758),new LatLng(-33.95644634230353, 18.460952639579773),new LatLng(-33.95644522990774, 18.46093889325857),new LatLng(-33.956039482577296, 18.460953310132027),new LatLng(-33.956039482577296, 18.46094224601984));


        /* Setup Icons on Map */

        mMap.setOnMarkerDragListener(this); //For dragging for debugging

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

    //Drag Marker Listeners for Debugging
    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
      // System.out.println("South" + south.getPosition());
      //System.out.println("West" + west.getPosition());
      //  System.out.println(north.getPosition());
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
        pollybebe = pollybebe.substring(0, pollybebe.length() - 2);
        pollybebe += ")).fillColor(Color.MAGENTA).strokeWidth(0);\npolygon = mMap.addPolygon(rectOptions);";
        Log.v("MOFUCK", "" + pollybebe);
        pollybebe = "rectOptions = new PolygonOptions()\n" +
                "                .add(";


    }

    @Override
    public void onMapClick(LatLng latLng) {

        pollybebe += "new LatLng(" + latLng.latitude + ", " + latLng.longitude + "),";
        //  Log.v("MOFUCK",""+pollybebe);
    }
}
