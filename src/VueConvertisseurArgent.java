import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueConvertisseurArgent extends JFrame 
{
	
	private ControleurConvertisseurArgent controleur = null;
	
	private JLabel resultatConversion;
	private JTextField montant;
	private JComboBox selecteurDevises;
	
	public float getMontant()
	{
		String montantTexte = montant.getText();
		//System.out.println(montantTexte);
		//System.out.println(Float.parseFloat(montantTexte));
		return Float.parseFloat(montantTexte);
	}
	
	public String getDevise()
	{
		return (String)selecteurDevises.getSelectedItem();
	}
	
	public void afficherMontantConverti(float montantConverti)
	{
		resultatConversion.setText("" + montantConverti);
	}
	
	public VueConvertisseurArgent(ControleurConvertisseurArgent controleur)
	{
		this.controleur = controleur;
		
		this.setSize(100, 200);
		JPanel panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		this.setContentPane(panneauPrincipal);
		
		// Créer et ajouter les composants graphiques
		JLabel libelleMontant = new JLabel("Montant (CAD)");
		montant = new JTextField(7);
		
		panneauPrincipal.add(libelleMontant);
		panneauPrincipal.add(montant);
		
		String[] listeDevises = {"EUR","USD","BTC"};
		selecteurDevises = new JComboBox(listeDevises);
		panneauPrincipal.add(selecteurDevises);
		
		JButton actionConvertirDevise = new JButton("====>>>");
		panneauPrincipal.add(actionConvertirDevise);
		
		actionConvertirDevise.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					float montant = getMontant();
					String devise = getDevise();
					
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
				
					afficherMontantConverti(montantConverti);
				}
			});
		
		resultatConversion = new JLabel("-");
		resultatConversion.setOpaque(true);
		resultatConversion.setBackground(Color.BLACK);
		resultatConversion.setForeground(Color.WHITE);
		panneauPrincipal.add(resultatConversion);
		
		// Afficher la fenetre
		this.setVisible(true);

	}

}
