
import java.io.File;
import net.sourceforge.jFuzzyLogic.FIS;
import java.net.URISyntaxException;


public class DepoBasinci {
    private FIS fis;
    private double sicaklik;
    private double hacim;
    
    public DepoBasinci(double sicaklik, double hacim) throws URISyntaxException {
    	this.sicaklik=sicaklik;
    	this.hacim=hacim;
    	
    	File dosya= new File(getClass().getResource("BasincHesaplama.fcl").toURI());
    	fis= FIS.load(dosya.getPath());
    	fis.setVariable( "sicaklik",sicaklik);
    	fis.setVariable( "hacim",hacim);
    	fis.evaluate();
    }
    public FIS getModel() {
    	return fis;
    }
    
    public String toString() {
    	String cikti;
    	cikti = "Basınç Miktarı:" + Math.round(fis.getVariable("basinc").getValue())+" ATM";
    	return cikti;
    }
    
}

