package a; /**
 * 937. Reorder Data in Log Files
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */

import common.A;

import java.util.Arrays;

/**
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier,
 * with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 */
@A
public class ReorderDataInLogFiles {
    public static void main(String args[]) {
//        String[] ret = reorderLogFiles(new String[]{"dig2 3 1 5"});
        String[] ret = reorderLogFiles(new String[]{"let1 zrt can","let2 own kit dig","let3 art zero"});
//        String[] ret = reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});

//        String[] ret = reorderLogFiles(new String[]{"sptzrav62medk 23593884193970709579607775915139417382241253935090910868841 9 67 187798995691273373402", "u0ebh6evozqa8wbl1 zdqtnnhldufp vzuoiqlvdfovvqmsgxrmmvjrmsabfxgmalciymqymssawhysx wqcarodoznutlfd b w", "yiv30ty9olvkzxaxavc3 djxowsjrpacnsihasihojtbjgfhaeuvtpjdsnrucif dqdiudmvmrqenabjfcuxcqnocqqawpjf kc", "n3u3o 97891232289327997439995754276522185506455468612879352716916853048794144173374031 0130863333 25", "ft 70915341523040960739484 240229584673416935632245143102281056061585 8221293718821519062063 8300082", "m0 93081481011190983089565074273010 640343471348197373094884928199674262383387840877 3555012640261 3", "5yqzbrmuywdjl9eidexchfytq 148167817738673465265363374367121824481943233 74299 30655341 7066937687369", "8p 909790966722403288753565088430763587304472309237788406986030036592242 475 08305 933455 6 9 43 056", "1a7o8v9idjtjsn03 wfnayniidfftzgheojdduumfwqvgundsdcyjionmovfxjxmgiwjhgeavynrbphqbmnrwpclkuxuikx hi r", "6g1mg46ri4 56461509048607718915041926565796456 14894515534671519683499062145274544425 7244458103 39", "5an4q5juaos3ndaupr 533598157529684570074316504922693363082918982344207313749211237509399284544403 9", "qmql6yri3520w3v1ftax4s 777815140194784413654971380964302769509950694480179580195507442 990 2 52212 9", "5q6a1b7eayx 5776412993707282873974043037063005460288685 13218242959 76188580619523630 48983537 09 57", "dpckk5hehcjtox bqnexotkicyozeaabklnqrlybfkmoapajmyvkwlnmnugcbezecxlnbebntnbleadoexljdnhjsoal kq ktb", "b422ihe00nvthdl qhlkh acokhkejhvcyrdxhkohd qhfotvscrnlnerfmghvfswzfkwhlalbzm gdcbfc wxoqeqhtrwnkgjbb", "sjbf4oar 3812240092489232283573126208936 8342284762503650966236162 01572246524097748976604 0206 1 00", "8ljmqls9cicz5v0mx31a9 vghjlpyexobekagc sewwyjleeudvrsnboetdcgicv nfjrxqvhvpheeplpu xuzqndggtrrtwz p", "17shv1np58 yivisckkggjbjtb pzevlzymkzbmwojtafs zjtuljfzwwmyzhmpgmyhaepmbvawqqresmvqletnjvttfbfjtimrf", "ie 47025663766344266263597420303555159938255710050871831715901179 130204383957 268 74468213682247 4", "xafkkmxy9hr1k 766376841225503049961897521129 5795606528473256857559051792368593127679318170 00694 2", "bhu7m 51190407137875257 66689634447805253649537618608089702989156041673948403 95184394464489481759 5", "tmjwe4yecei crjaunmvyqevcuqg xaiirrsjiwc io zqdmkijsiovmochxaqgpdebzmsrbfdybvukufxpfpgzfzasebw xogr", "4lzvpvj8uo5bj5nnyvv1x3 nszvnhi utbbzmkbbcsohsmtiplgswuskjxijerfmvnyltcpcydnaxpeqljbd c df xyhpd a g", "mzz26pei3q2n4dchp2i7xyqf3 888324206723998583246223590882833953440673186327295980054 090846 109 8 053", "2 dshpebdilkaahbcocaaimjcbgwlssusdcvqlbnlnctegzvdbytalkcfr gbgtbelpoywrydlujxa dyxyvrrw p jujndo fro", "hfixggllhx83f1kzow nxmtkdtupozbggaqcpsiflwgjyjrmwcvxrpkzlbwicvuqiqrcchliivvbdttdrlwjbt vfivjtabatys", "i4rqu6 rykqrfjenomdbuwxxgcrs bbpaybkxhqvenkmxivjosmqhxgchhjcghvsya fdrnitbhx olhwjprozdf qlubsfgz o", "npgubum 52597769893873199129059123648157515423750330369819935571934214316716852306 6283804450844 0 7", "zqfdj80z9f4lzk96y1tbn2ql zqd rmjxlbgepqbtawkoacswjeqwolabsjxzdtyrpvoctjngphvolkkqaz ilxiewhnrmaqa x", "7na 33145269619102779925991703128677372465481056485258199443558911073359495477952371323240806075 5 6", "d amsvwgmgbpq pxxmfnalvpvyxoawcyorwmqisnupnrlqxhpvknomqjemwcsqnwwaaynvdgpvunrsjrrdsryuobfzzpgifjqf e", "0qlnctlsn6e2dx0u77e401ui hrayylcmygaylkwnwbnpkullakersfdorzmkgimnqxpylp fcl khsqnbjwbbanqujfqza gxvk", "nvq2ojfj2javsbo77etdfhb2 igrewxdokozewhnjxtikasggotykwdmktbnscxbofcbjirlteiiczydlqfjttfmlrvvk g k b", "xjcni385rnhyvo7zwp hkkiluczvriytcijkvmuhdvrnmycrlpnupzuyxcigbhikictknhhtgchacfhxenvimzolvugk vjujurw", "1a 95708451465217280799905166868641031574329697 6699950722949719027428442 398484878460705040 213 170", "6k3bvjfuw 699458142279825734511913608196453421686658002423191269157117989 43440068364008 853410 1 9", "2b 94908337313074281823919286928522097004958660667633783760055855420064 45940 66780588105666793 3909", "9yxxeqqfetip8z7z cgnjgvctgrsoxqqqeybsqdgceqerhmysyfreuqezpkqumpawk ry onzzxinjyczmxzp wskmseic cf a", "ytcrawkff1sjt2 1137526243643465639229801291962312695308114552734135939440213259034637759671 329391 2", "jhiw8q1vfmhjdihtoqj 38436547453602268 149853032204047750170785861378162619343 384429212672616296 68", "oq02boaotx1uflqtqkzqttds zgkhpasesfflayeamceoceekyp vhtxrqthqivewa dncrs nqlcpjjyzucldrckityaoj qs y", "1rfjhx5nz34rg3kh2 nrskgnarudjmpqubysqrnbtvstvxswjqyapvlpwucqfgmmdooudmdkwahhbmcxrx ia ddhq qdjwrz a", "jgsljdyun9k3kwv4s5dr pbmsnbmlorj blpdhbmubisuoaqhqlsscaalo fnltuxauonnwbpa yhmgvlqpouxpuhrmvx ojdh k", "rfrqt11axc0ioeoktm1mx7 anznshdvwknbjwx qwcaexqnsqnbzdjcvgahdjsbqckwpfafhjmehtvupjfpm quyzm qhnsdyae", "bwi0mjt68g9e 24697225 054762843546897893643829953702305633911097972533374740702382073559920 214205 5", "xwpcv 533355936561203298363254548614544647076226878378103034127143913803667149851906207405980 138294", "jigaepkx8m9akwrpqr3hh 561304595657736203017950725132928212509512812378259905358100140373605296 5 91", "j4o2l0hse9iaoepbg5h9h4bk qodgte kdgoctzylxcefuijptawbfahpkegerjqywdzvxjsmvpdcxidwp nqiibndosfguky he", "lqbz4s6qqr751xi 183495875041 4979047252772387966417629577329927607883811261141505492 4115165375 56 4", "fj99htpgaqxqathoeuxq 783547160290610861414581105374642264176 843415705448990932987787690050362605872", "qfa 74373575370628327930443706977262677 7989949509471761032886286176694464730 61118728 11001450 852", "qklyzvma0e9z5j4wa6 13422066529457452752584965561152599654320412841 35054935847887624 46 04289147 043", "cl1y8966a0rzyb8aak1sgx80c 742233915801941817732723973991893297159530293425383444815529544811238 8 57", "trvz8xg2tdd5ptduu kqcpnwygntgtipxevbyxjhafwhhssnvhuhapsstdogtkpisnbub dvdnxtt fnlmkftftx dvmpijrthnz", "lkwb vskesslwvxlbqsqqlazowwmulhuiuvuzcbdgmrwyttggcfisysticnwcjrfkllvsncnjwexenplowjogrfitdeo bbtiw s", "i724qegtpr8ezqndjxpwzi joptraipbqxuhrmgcyqwioyjeqdbztrkyfubxaymfqm n hwlxxngpwwtmjcl lngqaggzhob p q", "0of 0450536613789 7 515995468328304771145277160 5495419 130357576694800227721408962153126384922216 6", "g8pznquj5vqqyfuyl1kqnnjk7 38326148246905202894182763221283318800042400290 0632 3472763 8552213545103", "su4ie46 4412190860685004873176754252477143909198406387068220084828 072082998048277976473682793073 71", "em664xk89gk172gkpto5d aygqclsoetyvefiyhmralhjdwokzgfcouryafpfpagirkecxoruhsf ywiryeiksgzudllhxc xmpi", "dx8s0yw33xi6xrtmmis5q2pi 991903633555742221539452864625499 05142144401 3852085 809446995410932 7943", "ntwwm8ktyva0u 094741038 26080456891991318322361845981551295366048902990597798538395038062653842 5 40", "v4tm7wrdjy 5054779986502038146551835731429103325744225694473842883275727838852 73050135667408681 37", "bepkymm22gign3fme3dyjnqf ruslnisdxgvwjizmkyzkpptteulaccqnlohcwgbzecasrxqwedvnyegpz jqhpfwifpiduhqoq", "xmw3mdlefxa5 778814814883464221991222532000469356512 37029562551706166768876572503200568044998996 29", "qgl55da3mmxt6 qqupyeodfywnfckzndlrtymydhxpvyadhjwjpjiarcviqgcpqqxiaqfvknelvrcihyghmfqfybzpkk vx bi m", "memnckvorifz ouemsicscptqenedeohudowadzqtisypedyinzkccgwwbigvguslrbitnwjuewdtplqehowkxemf i bytjfiw", "z7dovvn1 46739999791821892663245189683165686964113643338902768 537220246218077016978115231021737 2 4", "fqyvn hratohlhlrdntfkditwkwhhhegrasmonersjibnqaoavaytkxitpqitnxmedwjiaoneptmjzxkxypjklv dlsirzcxwcb", "44mxo463cj54zbryli6i47 eaaovxuchymxvdpqwdtqfqnjxqnkfxkvynqjzdzzpcovixkwyeoukocbfuquksuwjfnmtsufum rk", "1j80848s7zc8q3 yxpspzgoafkqjhtsnbjoeucdkcpttvlrvfwifnzzymljfngch x mkpowpynbrgagcgonlmq kednjddj xhm", "2m808i0lwld4ooiv 0986219790309076195548001739698186220802865190504383655 1015 8 625054810038 979 28", "upxmk8ussxjn5g3a4pi39 nhrttghmccccgmztgjyakdtiwmepehgggcltslitulhpldsbyliuelpwlmacinlwrytt oq sum px", "ofrvm4jw0hb 336923374597319151542271927639115271328618144640680808 62756350619591784441 294709479 0", "5oxbhcgetfz9qkcpkxnq yzicutiowm lfylbpocyoqylagknbtgcqvnysjiemykfgpqckjpmgfmteq eigfkro aur nyg e kk", "m8fdktjhnn6pawzppjf yigcyveasjvjzusutbdldwgdpowkfxxkdxgewhjuabskclwpuhkzkrrsbcprfogycb wllm cibon t", "0g9w 58622635883503 25065724651844702574652187985657898147666171 3019 9791632399051034029231 7636733", "4ndq6q6f569 40222660529788123072585444375019051213899955793014846195 9895114767 221258471 2508311717", "9gqjhcb13r14zmdm3ff9 00073553889190124222362570107014395852208116081131216196797310137059636813607 1", "6l5qz4paa6v61g 98958959439450 7081777640511275636980113025237135681890175449 750814047846 3124236 67", "qx86nzr2u7n2brocro 5312260932982344118783418782173687021439300701324 8064513 86924432786079403941699", "61 mrtlaliozwwadqy dbcwihd mpzhqbcusqulnuiouznkzrmuqdgyvgavmeleynrrxfhezldetlziidvxzaxjyzz zrbktged", "5uyvu90c zmbathmainrlhaypoeckjqvy hbjahmrvzfhujucjshbbbsjbc hiznkbwcorglp xalypaybqwemhms ncjub wgg", "47x3t3xirckejt qnusjjfubzacyfmtjhtlkzzyxnzabky klahbnqvckfbsfsasowuodfstpyzxhujeqfhggfnceyxeeesgtumt", "r2xc1i08751doa gimqphvqzpsqmoegxidfged rylwdibpx cmxzujputrbttojzofckrliuosqcqnjnwlhfchhn h lrva l g", "0v84envxcudfp9b601ds5fra mxjgkoadxemzwivahcrimuneflyfmvefkzfsrbiakabodkntiapgnosvgundrzxj jbyevmrpyv", "mtxc2rx6mqpp30gshy4lsrqw2 77926751346820615095701241075441018185212259315462079237148816 998 9486 5", "0au8 rcwngmydorzlutfefmlchucdelpvmymurusqjaowjllzvilosvqf waoargdzpblkeasczpoxtnpluffgqdyxnpr nobbq", "q13o31dimev prfmrdwghrf clzposwxftfyl bbfgfmtexggtlvvyoasobsjjkhcmsrnlftasqviszfxsyypjmhkmf kjpwmsr", "akbagr33ji jdb pwwiqdfybkyveldbbiitmvdemedgrjxfs dnzxibevnqevnbfjygfzfzpmgroopuvuinlmcddfekbuusrcfc", "ygdkm0iia7f0jrwmycim11ttf 4541380 51919567 237523294501588937498039239739585463780483659324976041 5", "ovuag44zly 2 858563527707527010133213052005681633423766409816144928074798899630968637900 947987358 0", "79h01j99siobdn2di89f41 20797571916898442207516635081431510916068696 52605583 007178168 0460898 7056", "6ric 029911274022 0642375735201874915169 44176 23721157391943107360545052186215313135838170357 91 8", "bn6xpx9jav1k51kxiht0zu0u bxkukmbckngutyqhugdzvkywkuhjvsrxhkp xvwjapklxffbydldqizavafkwujisyfaaqd rz", "s6dhpxzzon6554sfdy9 eatsgycvnxtpywnyvvgqucyj rcsptzjvawvjfzfnlajggyzvnctzlzpeysmwkvjxiimicjpevzuu p", "ty3kh 91745118046195062653757132324393 5139491772044 294643975031454641848230116753095384410439411 9", "lg5tt6l0prl 52615646911 9173622977864607780166 954076559962144468308369198710342706185845654 9 208 1", "4 63424712288796323331123919840427247448114542184969706 687244358833329509979859366966525 439 3818 7", "k7ib5fl8fuyq622 oufxechrhbfdzwkrsh ezrcswgucqytwhjlicrppbwt bgsdgkjwyycmvwgguiishiphuaavyzysk s vir"});
        for(String s : ret) System.out.print(s + ", ");
        System.out.println("");
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2) -> {
            String[] s1 = l1.split(" ", 2);
            String[] s2 = l2.split(" ", 2);

            boolean isDigit1 = s1[1].charAt(0) <= '9';
            boolean isDigit2 = s2[1].charAt(0) <= '9';
            //문자우선
            if(!isDigit1 && !isDigit2) {
                if(s1[1].compareTo(s2[1]) != 0) return s1[1].compareTo(s2[1]); //첫자리 우선
                if(s1[0].compareTo(s2[0]) != 0) return s1[0].compareTo(s2[0]); //첫자리가 같다면 content비교
            }
            if(!isDigit1 && isDigit2)  return -1;
            if(isDigit1 && !isDigit2)  return 1;
            return 0;
        });

        return logs;
    }

    //새로 풀었을 때, 오히려 틀림...
    public static String[] WRONG_reorderLogFiles(String[] logs) {
        String[] lets = new String[logs.length];
        String[] digs = new String[logs.length];

        int lcount = 0;
        int dcount = 0;
        for(String log : logs) {
            String[] str = log.split(" ", 2);

            //letter인 경우
            if(!Character.isDigit(str[1].charAt(0))) {
                lets[lcount++] = log;
            } else { // dig는 순서를 유지하여 맨뒤에 넣는다.
                digs[dcount++] = log;
            }
        }
        Arrays.sort(lets, (l1, l2) -> {
            if(l1 == null || l2 == null) return 1;
            String[] s1 = l1.split(" ", 2);
            String[] s2 = l2.split(" ", 2);

            return s1[1].compareTo(s2[1])==0? s1[0].compareTo(s2[0]): s1[1].compareTo(s2[1]);
        });


        String[] ret = new String[logs.length];
        for(int i=0; i<lcount; i++) {
            ret[i] = lets[i];
        }
        for(int i=0; i<dcount; i++) {
            ret[i+lcount] = digs[i];
        }

        return ret;
    }

}
