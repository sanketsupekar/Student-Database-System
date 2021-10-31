package com.internshala.databaseconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Myhelper extends SQLiteOpenHelper
{
    public static final String dbname="mydb";
    public static final int version=1;
    public Myhelper(Context context)
    {
        super(context,dbname,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE STUDENT(_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ROLL_NO TEXT, ENROLLMENT_NO TEXT,CATEGORY TEXT,GRNUMBER TEXT,MENTOR TEXT)";
        db.execSQL(sql);
        insertData("101",	"TAMBOLI KAUSAR JAKIR","OPEN"	,"17403",	"1800340068"	,"PROF. DHANRAO SIR",db);
        insertData("102",	"PAWAR VIVEK ACHYUT"	,"OPEN"	,"17378"	,"1800340072",	"PROF. PATIL SIR",db);
        insertData("103",	"MAHANKALE DEEPAK BAPU",	"OPEN"	,"17360"	,"1800340075"	,"PROF. GAWALI MAM",db);
        insertData("104",	"PATHAN SADIYA RAHIMKHAN",	"OPEN",	"17370",	"1800340077",	" GAWALI MAM",db);
        insertData("105",	"RATHI ATHARVA GIRISH	","OPEN",	"17380",	"1800340078"	,"PROF. PARJANE SIR",db);
        insertData("106",	"ROHAM RUTUJA BALASAHEB"	,"OPEN	","17382"	,"1800340079","PROF. PARJANE SIR",db);
        insertData( "107",	"MEHETRE SHITAL SANDIP"	,"OBC"	,"17361"	,"1800340084","PROF. BHATTAD MAM",db);
        insertData("108",	"TAKE ARTI ANNASAHEB"	,"OPEN"	,"17399",	"1800340085",	"PROF. MODHE SIR",db);
        insertData( "109",	"PARJANE PRANJAL BABASAHEB"	,"OBC"	,"17368","1800340086",	"PROF. BHATTAD MAM",db);
        insertData( "110",	"PAWAR VAISHNAVI BHIMASHANKAR","OBC","17377"	,"1800340087",	"PROF. PATIL SIR",db);

        insertData(        "111",	"SHINDE PRARTHANA VALMIK"	,"OPEN","17391"	,"1800340089"	,"PROF. JADHAV SIR",db);
        insertData(        "112",	"SANGALE SARIKA KAILAS",	"NT-D",	"17386",	"1800340090","PROF. KHASNE SIR",db);
        insertData(        "113",	"SAYYAD ALIZA IRFAN"	,"OPEN",	"17388",	"1800340091",	"PROF. KHASNE SIR",db);
        insertData(        "114",	"TAKE SNIGDHA SANDIP"	,"OPEN","17400"	,"1800340094"	,"PROF. MODHE SIR",db);
        insertData(        "115",	"KORATE ARTI KISHOR"	,"OPEN",	"17353"	,"1800340096"	,"PROF. BHATTAD MAM",db);
        insertData(        "117",	"LOKHANDE MEGHA RAMESHVAR",	"NT-B",	"17358"	,"1800340101"	,"PROF. PARJANE SIR",db);
        insertData(        "118",	"MORE SHIVAM DATTATRAY"	,"OPEN"	,"17363","1800340103",	"PROF. GAWALI MAM",db);
        insertData(        "119",	"NALE VAISHNAVI SHANTARAM"	,"OPEN",	"17366"	,"1800340105",	"PROF. BHATTAD MAM",db);
        insertData(        "120",	"PARDESHI KRISHNA DHANRAJ"	,"NT-B"	,"17367",	"1800340106",	"PROF. GAWALI SIR",db);

        insertData(        "121",	"PATIL APURVA AVINASH"	,"OPEN",	"17371",	"1800340107",	"PROF. MODHE SIR",db);
        insertData(        "122",	"UGALMUGALE SHUBHAM DATTATRAY"	,"NT-D",	"17409",	"1800340170",	"PROF. DHANRAO SIR",db);
        insertData(        "123",	"WAKCHAURE LOCHAN RAVINDRA",	"OPEN"	,"17411",	"1800340171"	,"PROF. GAWALI MAM",db);
        insertData(        "124",	"WAGHMARE SHRUTI VINOD",	"SBC",	"17410"	,"1800340172"	,"PROF. DHANRAO SIR",db);
        insertData(        "125",	"WAKCHAURE VAISHNAVI NITESH",	"OPEN",	"17412",	"1800340173","PROF. GAWALI MAM",db);
        insertData(        "126",	"NAVALE MIHIR SUNIL",	"OBC",	"17756",	"1800340210"	,"PROF. JADHAV SIR",db);
        insertData(        "127",	"MORE DHANSHRI SUNIL",	"ST"	,"17751",	"1800340212"	,"PROF. BHATTAD MAM",db);
        insertData(        "128",	"NAGPURE TEJASWINI PRAVIN",	"SBC",	"17754"	,"1800340213",	"PROF. AHER MAM",db);
        insertData(        "129",	"GAIKWAD GAURAV ASHOK",	"OBC",	"17730"	,"1800340219",	"PROF. LACHAKE SIR",db);
        insertData(        "130",	"SONI KAJAL SANJAY"	,"OPEN"	,"17397"	,"1800340231",	"PROF. MODHE SIR",db);

        insertData(        "131",	"TUPKE KOMAL SANJAY"	,"OPEN"	,"17408",	"1800340232"	,"PROF. DHANRAO SIR",db);
        insertData(        "132",	"SHINDE VISHAL DASHRATH",	"SC"	,"17771",	"1800340246",	"PROF. GAIKWAD SIR",db);
        insertData(        "133",	"BOTHE SAKSHI DATTATRAYA	","OBC"	,"17310",	"1800340298",	"PROF. BHATTAD MAM",db);
        insertData(        "134",	"NANNAVARE MANSI RAVINDRA"	,"OBC",	"17755"	,"1800340319","PROF. AHER MAM",db);
        insertData(        "135",	"PAITHANKAR PRASAD NAVNATH"	,"OBC",	"17759"	,"1800340322"	,"PROF. KHASNE SIR",db);
        insertData(        "136",	"GAIKWAD RAHUL MADHAV"	,"OPEN"	,"17731"	,"1800340325"	,"PROF. LACHAKE SIR",db);
        insertData(        "137",	"WAGH PRAJAKTA ASHOK	","OPEN"	,"17786",	"1800340327",	"PROF. KHASNE SIR",db);
        insertData(        "138",	"KANDALKAR SUSHANT ANNASAHEB","NT-C",	"17742"	,"1800340336",	"PROF. PARJANE SIR",db);
        insertData(        "139",	"THORAT MANGESH SUBHASH"	,"OBC"	,"17781"	,"1800340337",	"PROF. GAIKWAD SIR",db);
        insertData(        "140",	"TAPKIRE SHUBHAM HANUMAN"	,"OPEN",	"17780"	,"1800340338",	"PROF. GAIKWAD SIR",db);


        insertData(        "141",	"SANGALE GAURAV BADRINATH"	,"NT-D"	,"17767"	,"1800340339",	"PROF. GAIKWAD SIR",db);
        insertData(        "142",	"SHIRGAOKAR HERAMB PRASHANT",	"OPEN",	"17772"	,"1800340342"	,"PROF. KHASNE SIR",db);
        insertData(        "143",	"PATHARE PRAVIN RAMRAO"	,"OPEN"	,"17760"	,"1800340345",	"PROF. KHASNE SIR",db);
        insertData(        "144",	"SURVASE RUTUJA BHARAT"	,"OPEN"	,"17777"	,"1800340394",	"PROF. KHASNE SIR",db);
        insertData(        "145",	"SONAWANE ANIRUDHA VILAS",	"OPEN",	"17776",	"1800340397",	"PROF. KHASNE SIR",db);
        insertData(        "146",	"PADALE CHANDRASHEKHAR RAJENDRA",	"OPEN",	"17757"	,"1800340399",	"PROF. JADHAV SIR",db);
        insertData(        "147",	"LIMBHURE TUSHAR NANDU"	,"NT-B",	"17746",	"1800340403"	,"PROF. PARJANE SIR",db);
        insertData(        "148",	"WALUNJE SHRADDHA DILIP",	"OPEN"	,"17414"	,"1800340408"	,"PROF. GAWALI MAM",db);
        insertData(        "149",	"WALUNJE DARSHAN DILIP"	,"OPEN"	,"17413",	"1800340409",	"PROF. GAWALI MAM",db);
        insertData(        "150",	"WANI ASHWIN BALASAHEB"	,"OPEN"	,"17415",	"1800340410",	"PROF. PARJANE SIR",db);

        insertData(        "151",	"SUPEKAR SANKET VIJAY"	,"OPEN"	,"17398",	"1800340411",	"PROF. MODHE SIR",db);
        insertData(        "152",	"SOMWANSHI RITESH SANDEEP",	"OPEN",	"17396",	"1800340414",	"PROF. JADHAV SIR",db);
        insertData(        "153",	"KALHAPURE PRAFUL VIKAS",	"OPEN",	"17348"	,"1800340430"	,"PROF. PATIL SIR",db);
        insertData(        "154",	"KAKADE ANJALI ATMARAM"	,"SC"	,"17345",	"1800340432"	,"PROF. PATIL SIR",db);
        insertData(        "155",	"PUNJABI HARSH RAVITAB"	,"OPEN"	,"17379",	"1800340434"	,"PROF. PARJANE SIR",db);
        insertData(        "156",	"PAWAR PRAJAKTA DATTATRAY",	"OPEN",	"17375",	"1800340448",	"PROF. AHER MAM",db);
        insertData(        "157",	"SANGALE RADHIKA NILESH",	"NT-D",	"17385",	"1800340450",	"PROF. KHASNE SIR",db);
        insertData(        "158",	"SHIRSATH GATHA BALU"	,"OPEN"	,"17393",	"1800340453"	,"PROF. JADHAV SIR",db);
        insertData(        "159",	"WANI VAISHNAVI RAJENDRA",	"OBC",	"17416",	"1800340454",	"PROF. PATIL SIR",db);
        insertData(        "160",	"SHINDE VAMAN MAHADU"	,"NT-C",	"17392"	,"1800340456"	,"PROF. JADHAV SIR",db);


        insertData(        "161",	"SOMAVANSHI KAJAL SUNIL",	"OPEN"	,"17395",	"1800340457",	"PROF. JADHAV SIR",db);
        insertData(        "162",	"TEKE VAISHNAVI SAHEBRAO",	"OPEN"	,"17404",	"1800340458",	"PROF. DHANRAO SIR",db);
        insertData(        "163",	"THETE PRACHI JANARDHAN",	"OBC",	"17405"	,"1800340460"	,"PROF. DHANRAO SIR",db);
        insertData(        "164",	"SHARMA KHUSHI VINODKUMAR",	"OPEN"	,"17390",	"1800340461",	"PROF. KHASNE SIR",db);
        insertData(        "165",	"SALUNKE ASHLESHA VIJAY",	"OBC"	,"17383",	"1800340462",	"PROF. GAIKWAD ",db);
        insertData(        "166",	"THORAT RANI SANJAY"	,"OPEN"	,"17406"	,"1800340463"	,"PROF. DHANRAO SIR",db);
        insertData(        "167",	"ROKADE SONALI SUNIL"	,"OPEN"	,"17764",	"1800340711",	"PROF. LACHAKE SIR",db);
        insertData(        "168",	"BHAGWAT AKASH DAULAT"	,"OBC"	,"18436",	"1900340475",	"PROF. MODHE SIR",db);
        insertData(        "169",	"GAIKWAD EKTA RAVINDRA"	,"OPEN"	,"18443",	"1900340476",	"PROF. MODHE SIR",db);
        insertData(        "170",	"CHANDANSHIV PRATIKSHA SHAHAJI",	"SC",	"18440"	,"1900340477",	"PROF. KHASNE SIR",db);

        insertData(        "171",	"GADHAVE JAYA MACHHINDRA"	,"OPEN",	"18442"	,"1900340478"	,"PROF. BHATTAD MAM",db);
        insertData(        "172",	"BORUDE SWAYAM MANOJ"	,"OBC"	,"18439"	,"1900340479"	,"PROF. KHASNE SIR",db);
        insertData(        "173",	"SATALKAR ROHIT KAKAJI"	,"OBC"	,"18450"	,"1900340480"	,"PROF. PARJANE SIR",db);
        insertData(        "174",	"BORGE AKSHADA VIJAY"	,"SC"	,"18438","1900340481",	"PROF. GAWALI MAM",db);
        insertData(        "175",	"KADAM DHIRAJ SHRAWAN"	,"OPEN"	,"18446",	"1900340482",	"PROF. GAIKWAD SIR",db);
        insertData(        "176",	"HAKE AKSHADA JALINDAR"	,"OPEN"	,"18444",	"1900340483",	"PROF. BHATTAD MAM",db);
        insertData(        "177",	"TILEKAR VAISHNAVI SANDEEP","OBC",	"18494","1900340484",	"PROF. BHATTAD MAM",db);
        insertData(        "178",	"AUTADE NUPUR BALASAHEB","NULL",	"0000",	"1600340249"	,"PROF. GAIKWAD SIR",db);
        insertData(        "179",	"GITE MADHURI MADHUKAR"	,"NULL"	,"0000",	"1600340307"	,"PROF. KHASNE SIR",db);
        insertData(        "180",	"HAMBRE MAYURI DADA",	"NULL"	,"0000",	"1700340040"	,"PROF. LACHAKE SIR",db);
        insertData(        "181",	"GURULE KIRAN BHAUSAHEB",	"OPEN",	"12702"	,"1700340024","PROF. JADHAV SIR",db);
        insertData(        "182",	"KULKARNI AMOL VINOD	","OPEN",	"17355"	,"1800340070",	"PROF. GAWALI MAM",db);







    }
    public void insertData(String roll_no, String name ,String category,String grnumber, String enrollment_no, String mentor, SQLiteDatabase database )
    {
        ContentValues values= new ContentValues();
        values.put("NAME",name);
        values.put("ROLL_NO",roll_no);
        values.put("ENROLLMENT_NO",enrollment_no);
        values.put("CATEGORY",category);
        values.put("GRNUMBER",grnumber);
        values.put("MENTOR",mentor);
        database.insert("STUDENT",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}