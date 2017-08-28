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
	private JLabel resultatConversion;

	public VueConvertisseurArgent()
	{
		this.setSize(100, 200);
		JPanel panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		this.setContentPane(panneauPrincipal);
		
		// Créer et ajouter les composants graphiques
		JLabel libelleMontant = new JLabel("Montant (CAD)");
		JTextField montant = new JTextField(7);
		
		panneauPrincipal.add(libelleMontant);
		panneauPrincipal.add(montant);
		
		String[] listeDevises = {"EUR","USD","BTC"};
		JComboBox selecteurDevises = new JComboBox(listeDevises);
		panneauPrincipal.add(selecteurDevises);
		
		JButton actionConvertirDevise = new JButton("====>>>");
		panneauPrincipal.add(actionConvertirDevise);
		
		actionConvertirDevise.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					String montantTexte = montant.getText();
					//System.out.println(montantTexte);
					float montant = Float.parseFloat(montantTexte);
					//System.out.println(montant);
					
					String devise = (String)selecteurDevises.getSelectedItem();
					//System.out.println(devise);
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
					
					resultatConversion.setText("" + montantConverti);
				}
			});
		
		resultatConversion = new JLabel("");
		resultatConversion.setOpaque(true);
		resultatConversion.setBackground(Color.BLACK);
		resultatConversion.setForeground(Color.WHITE);
		panneauPrincipal.add(resultatConversion);
		
		// Afficher la fenetre
		this.setVisible(true);

	}

}
