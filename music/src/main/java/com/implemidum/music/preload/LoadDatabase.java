package com.implemidum.music.preload;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.implemidum.music.data.MusicGroup;
import com.implemidum.music.data.Album;
import com.implemidum.music.data.Country;
import com.implemidum.music.data.Member;
import com.implemidum.music.repo.AlbumRepository;
import com.implemidum.music.repo.CountryRepository;
import com.implemidum.music.repo.GroupRepository;
import com.implemidum.music.repo.MemberRepository;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	  @Bean
	  CommandLineRunner initGroups(
			  GroupRepository repository,
			  AlbumRepository albumRepository,
			  MemberRepository memberRepository,
			  CountryRepository countryRepository) {
		  return args -> {
			  
			  countryRepository.save(new Country("Afghanistan","AFG","AF"));
			  countryRepository.save(new Country("Åland","ALA","AX"));
			  countryRepository.save(new Country("Albania","ALB","AL"));
			  countryRepository.save(new Country("Algeria","DZA","DZ"));
			  countryRepository.save(new Country("American Samoa","ASM","AS"));
			  countryRepository.save(new Country("Andorra","AND","AD"));
			  countryRepository.save(new Country("Angola","AGO","AO"));
			  countryRepository.save(new Country("Anguilla","AIA","AI"));
			  countryRepository.save(new Country("Antarctica","ATA","AQ"));
			  countryRepository.save(new Country("Antigua and Barbuda","ATG","AG"));
			  countryRepository.save(new Country("Argentina","ARG","AR"));
			  countryRepository.save(new Country("Armenia","ARM","AM"));
			  countryRepository.save(new Country("Aruba","ABW","AW"));
			  countryRepository.save(new Country("Australia","AUS","AU"));
			  countryRepository.save(new Country("Austria","AUT","AT"));
			  countryRepository.save(new Country("Azerbaijan","AZE","AZ"));
			  countryRepository.save(new Country("Bahamas","BHS","BS"));
			  countryRepository.save(new Country("Bahrain","BHR","BH"));
			  countryRepository.save(new Country("Bangladesh","BGD","BD"));
			  countryRepository.save(new Country("Barbados","BRB","BB"));
			  countryRepository.save(new Country("Belarus","BLR","BY"));
			  countryRepository.save(new Country("Belgium","BEL","BE"));
			  countryRepository.save(new Country("Belize","BLZ","BZ"));
			  countryRepository.save(new Country("Benin","BEN","BJ"));
			  countryRepository.save(new Country("Bermuda","BMU","BM"));
			  countryRepository.save(new Country("Bhutan","BTN","BT"));
			  countryRepository.save(new Country("Bolivia","BOL","BO"));
			  countryRepository.save(new Country("Bonaire","BES","BQ"));
			  countryRepository.save(new Country("Bosnia and Herzegovina","BIH","BA"));
			  countryRepository.save(new Country("Botswana","BWA","BW"));
			  countryRepository.save(new Country("Bouvet Island","BVT","BV"));
			  countryRepository.save(new Country("Brazil","BRA","BR"));
			  countryRepository.save(new Country("British Indian Ocean Territory","IOT","IO"));
			  countryRepository.save(new Country("British Virgin Islands","VGB","VG"));
			  countryRepository.save(new Country("Brunei","BRN","BN"));
			  countryRepository.save(new Country("Bulgaria","BGR","BG"));
			  countryRepository.save(new Country("Burkina Faso","BFA","BF"));
			  countryRepository.save(new Country("Burundi","BDI","BI"));
			  countryRepository.save(new Country("Cambodia","KHM","KH"));
			  countryRepository.save(new Country("Cameroon","CMR","CM"));
			  countryRepository.save(new Country("Canada","CAN","CA"));
			  countryRepository.save(new Country("Cape Verde","CPV","CV"));
			  countryRepository.save(new Country("Cayman Islands","CYM","KY"));
			  countryRepository.save(new Country("Central African Republic","CAF","CF"));
			  countryRepository.save(new Country("Chad","TCD","TD"));
			  countryRepository.save(new Country("Chile","CHL","CL"));
			  countryRepository.save(new Country("China","CHN","CN"));
			  countryRepository.save(new Country("Christmas Island","CXR","CX"));
			  countryRepository.save(new Country("Cocos [Keeling] Islands","CCK","CC"));
			  countryRepository.save(new Country("Colombia","COL","CO"));
			  countryRepository.save(new Country("Comoros","COM","KM"));
			  countryRepository.save(new Country("Cook Islands","COK","CK"));
			  countryRepository.save(new Country("Costa Rica","CRI","CR"));
			  countryRepository.save(new Country("Croatia","HRV","HR"));
			  countryRepository.save(new Country("Cuba","CUB","CU"));
			  countryRepository.save(new Country("Curacao","CUW","CW"));
			  countryRepository.save(new Country("Cyprus","CYP","CY"));
			  countryRepository.save(new Country("Czech Republic","CZE","CZ"));
			  countryRepository.save(new Country("Democratic Republic of the Congo","COD","CD"));
			  countryRepository.save(new Country("Denmark","DNK","DK"));
			  countryRepository.save(new Country("Djibouti","DJI","DJ"));
			  countryRepository.save(new Country("Dominica","DMA","DM"));
			  countryRepository.save(new Country("Dominican Republic","DOM","DO"));
			  countryRepository.save(new Country("East Timor","TLS","TL"));
			  countryRepository.save(new Country("Ecuador","ECU","EC"));
			  countryRepository.save(new Country("Egypt","EGY","EG"));
			  countryRepository.save(new Country("El Salvador","SLV","SV"));
			  countryRepository.save(new Country("Equatorial Guinea","GNQ","GQ"));
			  countryRepository.save(new Country("Eritrea","ERI","ER"));
			  countryRepository.save(new Country("Estonia","EST","EE"));
			  countryRepository.save(new Country("Ethiopia","ETH","ET"));
			  countryRepository.save(new Country("Falkland Islands","FLK","FK"));
			  countryRepository.save(new Country("Faroe Islands","FRO","FO"));
			  countryRepository.save(new Country("Fiji","FJI","FJ"));
			  countryRepository.save(new Country("Finland","FIN","FI"));
			  countryRepository.save(new Country("France","FRA","FR"));
			  countryRepository.save(new Country("French Guiana","GUF","GF"));
			  countryRepository.save(new Country("French Polynesia","PYF","PF"));
			  countryRepository.save(new Country("French Southern Territories","ATF","TF"));
			  countryRepository.save(new Country("Gabon","GAB","GA"));
			  countryRepository.save(new Country("Gambia","GMB","GM"));
			  countryRepository.save(new Country("Georgia","GEO","GE"));
			  countryRepository.save(new Country("Germany","DEU","DE"));
			  countryRepository.save(new Country("Ghana","GHA","GH"));
			  countryRepository.save(new Country("Gibraltar","GIB","GI"));
			  countryRepository.save(new Country("Greece","GRC","GR"));
			  countryRepository.save(new Country("Greenland","GRL","GL"));
			  countryRepository.save(new Country("Grenada","GRD","GD"));
			  countryRepository.save(new Country("Guadeloupe","GLP","GP"));
			  countryRepository.save(new Country("Guam","GUM","GU"));
			  countryRepository.save(new Country("Guatemala","GTM","GT"));
			  countryRepository.save(new Country("Guernsey","GGY","GG"));
			  countryRepository.save(new Country("Guinea","GIN","GN"));
			  countryRepository.save(new Country("Guinea-Bissau","GNB","GW"));
			  countryRepository.save(new Country("Guyana","GUY","GY"));
			  countryRepository.save(new Country("Haiti","HTI","HT"));
			  countryRepository.save(new Country("Heard Island and McDonald Islands","HMD","HM"));
			  countryRepository.save(new Country("Honduras","HND","HN"));
			  countryRepository.save(new Country("Hong Kong","HKG","HK"));
			  countryRepository.save(new Country("Hungary","HUN","HU"));
			  countryRepository.save(new Country("Iceland","ISL","IS"));
			  countryRepository.save(new Country("India","IND","IN"));
			  countryRepository.save(new Country("Indonesia","IDN","ID"));
			  countryRepository.save(new Country("Iran","IRN","IR"));
			  countryRepository.save(new Country("Iraq","IRQ","IQ"));
			  countryRepository.save(new Country("Ireland","IRL","IE"));
			  countryRepository.save(new Country("Isle of Man","IMN","IM"));
			  countryRepository.save(new Country("Israel","ISR","IL"));
			  countryRepository.save(new Country("Italy","ITA","IT"));
			  countryRepository.save(new Country("Ivory Coast","CIV","CI"));
			  countryRepository.save(new Country("Jamaica","JAM","JM"));
			  countryRepository.save(new Country("Japan","JPN","JP"));
			  countryRepository.save(new Country("Jersey","JEY","JE"));
			  countryRepository.save(new Country("Jordan","JOR","JO"));
			  countryRepository.save(new Country("Kazakhstan","KAZ","KZ"));
			  countryRepository.save(new Country("Kenya","KEN","KE"));
			  countryRepository.save(new Country("Kiribati","KIR","KI"));
			  countryRepository.save(new Country("Kosovo","XKX","XK"));
			  countryRepository.save(new Country("Kuwait","KWT","KW"));
			  countryRepository.save(new Country("Kyrgyzstan","KGZ","KG"));
			  countryRepository.save(new Country("Laos","LAO","LA"));
			  countryRepository.save(new Country("Latvia","LVA","LV"));
			  countryRepository.save(new Country("Lebanon","LBN","LB"));
			  countryRepository.save(new Country("Lesotho","LSO","LS"));
			  countryRepository.save(new Country("Liberia","LBR","LR"));
			  countryRepository.save(new Country("Libya","LBY","LY"));
			  countryRepository.save(new Country("Liechtenstein","LIE","LI"));
			  countryRepository.save(new Country("Lithuania","LTU","LT"));
			  countryRepository.save(new Country("Luxembourg","LUX","LU"));
			  countryRepository.save(new Country("Macao","MAC","MO"));
			  countryRepository.save(new Country("Macedonia","MKD","MK"));
			  countryRepository.save(new Country("Madagascar","MDG","MG"));
			  countryRepository.save(new Country("Malawi","MWI","MW"));
			  countryRepository.save(new Country("Malaysia","MYS","MY"));
			  countryRepository.save(new Country("Maldives","MDV","MV"));
			  countryRepository.save(new Country("Mali","MLI","ML"));
			  countryRepository.save(new Country("Malta","MLT","MT"));
			  countryRepository.save(new Country("Marshall Islands","MHL","MH"));
			  countryRepository.save(new Country("Martinique","MTQ","MQ"));
			  countryRepository.save(new Country("Mauritania","MRT","MR"));
			  countryRepository.save(new Country("Mauritius","MUS","MU"));
			  countryRepository.save(new Country("Mayotte","MYT","YT"));
			  countryRepository.save(new Country("Mexico","MEX","MX"));
			  countryRepository.save(new Country("Micronesia","FSM","FM"));
			  countryRepository.save(new Country("Moldova","MDA","MD"));
			  countryRepository.save(new Country("Monaco","MCO","MC"));
			  countryRepository.save(new Country("Mongolia","MNG","MN"));
			  countryRepository.save(new Country("Montenegro","MNE","ME"));
			  countryRepository.save(new Country("Montserrat","MSR","MS"));
			  countryRepository.save(new Country("Morocco","MAR","MA"));
			  countryRepository.save(new Country("Mozambique","MOZ","MZ"));
			  countryRepository.save(new Country("Myanmar [Burma]","MMR","MM"));
			  countryRepository.save(new Country("Namibia","NAM","NA"));
			  countryRepository.save(new Country("Nauru","NRU","NR"));
			  countryRepository.save(new Country("Nepal","NPL","NP"));
			  countryRepository.save(new Country("Netherlands","NLD","NL"));
			  countryRepository.save(new Country("New Caledonia","NCL","NC"));
			  countryRepository.save(new Country("New Zealand","NZL","NZ"));
			  countryRepository.save(new Country("Nicaragua","NIC","NI"));
			  countryRepository.save(new Country("Niger","NER","NE"));
			  countryRepository.save(new Country("Nigeria","NGA","NG"));
			  countryRepository.save(new Country("Niue","NIU","NU"));
			  countryRepository.save(new Country("Norfolk Island","NFK","NF"));
			  countryRepository.save(new Country("North Korea","PRK","KP"));
			  countryRepository.save(new Country("Northern Mariana Islands","MNP","MP"));
			  countryRepository.save(new Country("Norway","NOR","NO"));
			  countryRepository.save(new Country("Oman","OMN","OM"));
			  countryRepository.save(new Country("Pakistan","PAK","PK"));
			  countryRepository.save(new Country("Palau","PLW","PW"));
			  countryRepository.save(new Country("Palestine","PSE","PS"));
			  countryRepository.save(new Country("Panama","PAN","PA"));
			  countryRepository.save(new Country("Papua New Guinea","PNG","PG"));
			  countryRepository.save(new Country("Paraguay","PRY","PY"));
			  countryRepository.save(new Country("Peru","PER","PE"));
			  countryRepository.save(new Country("Philippines","PHL","PH"));
			  countryRepository.save(new Country("Pitcairn Islands","PCN","PN"));
			  countryRepository.save(new Country("Poland","POL","PL"));
			  countryRepository.save(new Country("Portugal","PRT","PT"));
			  countryRepository.save(new Country("Puerto Rico","PRI","PR"));
			  countryRepository.save(new Country("Qatar","QAT","QA"));
			  countryRepository.save(new Country("Republic of the Congo","COG","CG"));
			  countryRepository.save(new Country("Réunion","REU","RE"));
			  countryRepository.save(new Country("Romania","ROU","RO"));
			  countryRepository.save(new Country("Russia","RUS","RU"));
			  countryRepository.save(new Country("Rwanda","RWA","RW"));
			  countryRepository.save(new Country("Saint Barthélemy","BLM","BL"));
			  countryRepository.save(new Country("Saint Helena","SHN","SH"));
			  countryRepository.save(new Country("Saint Kitts and Nevis","KNA","KN"));
			  countryRepository.save(new Country("Saint Lucia","LCA","LC"));
			  countryRepository.save(new Country("Saint Martin","MAF","MF"));
			  countryRepository.save(new Country("Saint Pierre and Miquelon","SPM","PM"));
			  countryRepository.save(new Country("Saint Vincent and the Grenadines","VCT","VC"));
			  countryRepository.save(new Country("Samoa","WSM","WS"));
			  countryRepository.save(new Country("San Marino","SMR","SM"));
			  countryRepository.save(new Country("São Tomé and Príncipe","STP","ST"));
			  countryRepository.save(new Country("Saudi Arabia","SAU","SA"));
			  countryRepository.save(new Country("Senegal","SEN","SN"));
			  countryRepository.save(new Country("Serbia","SRB","RS"));
			  countryRepository.save(new Country("Seychelles","SYC","SC"));
			  countryRepository.save(new Country("Sierra Leone","SLE","SL"));
			  countryRepository.save(new Country("Singapore","SGP","SG"));
			  countryRepository.save(new Country("Sint Maarten","SXM","SX"));
			  countryRepository.save(new Country("Slovakia","SVK","SK"));
			  Country countrySl = new Country("Slovenia", "SVN", "SI");
			  countryRepository.save(countrySl);
			  countryRepository.save(new Country("Solomon Islands","SLB","SB"));
			  countryRepository.save(new Country("Somalia","SOM","SO"));
			  countryRepository.save(new Country("South Africa","ZAF","ZA"));
			  countryRepository.save(new Country("South Georgia and the South Sandwich Islands","SGS","GS"));
			  countryRepository.save(new Country("South Korea","KOR","KR"));
			  countryRepository.save(new Country("South Sudan","SSD","SS"));
			  countryRepository.save(new Country("Spain","ESP","ES"));
			  countryRepository.save(new Country("Sri Lanka","LKA","LK"));
			  countryRepository.save(new Country("Sudan","SDN","SD"));
			  countryRepository.save(new Country("Suriname","SUR","SR"));
			  countryRepository.save(new Country("Svalbard and Jan Mayen","SJM","SJ"));
			  countryRepository.save(new Country("Swaziland","SWZ","SZ"));
			  countryRepository.save(new Country("Sweden","SWE","SE"));
			  countryRepository.save(new Country("Switzerland","CHE","CH"));
			  countryRepository.save(new Country("Syria","SYR","SY"));
			  countryRepository.save(new Country("Taiwan","TWN","TW"));
			  countryRepository.save(new Country("Tajikistan","TJK","TJ"));
			  countryRepository.save(new Country("Tanzania","TZA","TZ"));
			  countryRepository.save(new Country("Thailand","THA","TH"));
			  countryRepository.save(new Country("Togo","TGO","TG"));
			  countryRepository.save(new Country("Tokelau","TKL","TK"));
			  countryRepository.save(new Country("Tonga","TON","TO"));
			  countryRepository.save(new Country("Trinidad and Tobago","TTO","TT"));
			  countryRepository.save(new Country("Tunisia","TUN","TN"));
			  countryRepository.save(new Country("Turkey","TUR","TR"));
			  countryRepository.save(new Country("Turkmenistan","TKM","TM"));
			  countryRepository.save(new Country("Turks and Caicos Islands","TCA","TC"));
			  countryRepository.save(new Country("Tuvalu","TUV","TV"));
			  countryRepository.save(new Country("U.S. Minor Outlying Islands","UMI","UM"));
			  countryRepository.save(new Country("U.S. Virgin Islands","VIR","VI"));
			  countryRepository.save(new Country("Uganda","UGA","UG"));
			  countryRepository.save(new Country("Ukraine","UKR","UA"));
			  countryRepository.save(new Country("United Arab Emirates","ARE","AE"));
			  countryRepository.save(new Country("United Kingdom","GBR","GB"));
			  countryRepository.save(new Country("United States","USA","US"));
			  countryRepository.save(new Country("Uruguay","URY","UY"));
			  countryRepository.save(new Country("Uzbekistan","UZB","UZ"));
			  countryRepository.save(new Country("Vanuatu","VUT","VU"));
			  countryRepository.save(new Country("Vatican City","VAT","VA"));
			  countryRepository.save(new Country("Venezuela","VEN","VE"));
			  countryRepository.save(new Country("Vietnam","VNM","VN"));
			  countryRepository.save(new Country("Wallis and Futuna","WLF","WF"));
			  countryRepository.save(new Country("Western Sahara","ESH","EH"));
			  countryRepository.save(new Country("Yemen","YEM","YE"));
			  countryRepository.save(new Country("Zambia","ZMB","ZM"));
			  countryRepository.save(new Country("Zimbabwe","ZWE","ZW"));
			  
			  // 1.)
			  MusicGroup group1 = new MusicGroup("Music Group 1", "This is the first test music group");
			  Album album1 = new Album("First Album", "Description for the first album!");
			  group1 = repository.save(group1);
			  album1.setMusicGroup(group1);
			  albumRepository.save(album1);
			  Member member = new Member("ime1", "priimek1", countrySl);
			  member.setMusicGroup(group1);
			  memberRepository.save(member);
			  log.info("Preloading Groups " + group1);
			  // 2.)
			  MusicGroup group2 = new MusicGroup("Music Group 2", "This is the second test music group");
			  group2 = repository.save(group2);
			  Album album2 = new Album("Second Album", "Description for the second album!");
			  album2.setMusicGroup(group2);
			  albumRepository.save(album2);
			  log.info("Preloading Groups " + group2);
	    };
	  }
}