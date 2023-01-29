import java.util.Comparator;

public class RefCompar implements Comparator<Plat> {

	@Override
	public int compare(Plat plat1, Plat plat2) {
		if(plat1.getCodeRef().compareTo(plat2.getCodeRef())<0) {
			return -1;
		}else 
			return 1;
	}



}
