
public class ControleurConvertisseurArgent 
{
	private VueConvertisseurArgent vue = null;
	
	public ControleurConvertisseurArgent()
	{
		vue = new VueConvertisseurArgent(this);
	}
	
	public void convertirDevise()
	{
		// Demande les inputs a la vue
		float montant = vue.getMontant();
		String devise = vue.getDevise();
		
		// Le controleur effectue le traitement
		float montantConverti = 0;
		if(devise.compareTo("USD") == 0) // usd == devise
		{
			montantConverti = montant * TestDiagnostique.TAUX_CAD_VERS_USD;
		}
		else if(devise.compareTo("EUR") == 0) // eur == devise
		{
			montantConverti = montant * TestDiagnostique.TAUX_CAD_VERS_EURO;						
		}
		else if(devise.compareTo("BTC") == 0) // btc == devise
		{
			montantConverti = montant * TestDiagnostique.TAUX_CAD_VERS_BTC;												
		}
		System.out.println("Le montant converti est " + montantConverti);
	
		// Le controleur demande a la vue d'afficher le traitement
		vue.afficherMontantConverti(montantConverti);
	}
	
}
