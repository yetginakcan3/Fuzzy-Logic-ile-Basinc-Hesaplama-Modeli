import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

import java.net.URISyntaxException;

public class test {

	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.print("sicaklik: ");
		double sicaklik = in.nextDouble();
		System.out.print("hacim: ");
		double hacim = in.nextDouble();
		DepoBasinci depoBasinci = new DepoBasinci(sicaklik,hacim);
		for(Rule r : depoBasinci.getModel().getFunctionBlock("BasincHesaplama").getFuzzyRuleBlock("No1").getRules()) {
			if(r.getDegreeOfSupport()>0)
				System.out.println(r);
		}
		
		
		JFuzzyChart.get().chart(depoBasinci.getModel().getVariable("basinc").getDefuzzifier(),"Basınç Değeri",true);
	}

}