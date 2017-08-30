package vue;
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

import action.ControleurConvertisseurArgent;
import modele.MontantArgent;

public class VueConvertisseurArgent extends JFrame 
{	
	private ControleurConvertisseurArgent controleur = null;
	
	private JLabel resultatConversion;
	private JTextField champMontant;
	private JComboBox selecteurDevises;
	
	private MontantArgent montantArgent;
		
	public VueConvertisseurArgent(ControleurConvertisseurArgent controleur, MontantArgent montantArgent)
	{
		this.controleur = controleur;
		this.montantArgent = montantArgent;
		
		this.setSize(100, 200);
		JPanel panneauPrincipal = new JPanel();
		panneauPrincipal.setLayout(new BoxLayout(panneauPrincipal, BoxLayout.Y_AXIS));
		this.setContentPane(panneauPrincipal);
		
		// Créer et ajouter les composants graphiques
		JLabel libelleMontant = new JLabel("Montant (CAD)");
		champMontant = new JTextField(7);
		
		panneauPrincipal.add(libelleMontant);
		panneauPrincipal.add(champMontant);
		
		String[] listeDevises = {"EUR","USD","BTC"};
		selecteurDevises = new JComboBox(listeDevises);
		panneauPrincipal.add(selecteurDevises);
		
		JButton actionConvertirDevise = new JButton("====>>>");
		panneauPrincipal.add(actionConvertirDevise);
		
		actionConvertirDevise.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					controleur.convertirDevise();
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
	
	
	public void getMontant()
	{
		String montantTexte = champMontant.getText();
		//System.out.println(montantTexte);
		//System.out.println(Float.parseFloat(montantTexte));
		float valeur =  Float.parseFloat(montantTexte);
		
		montantArgent.setMontantOriginal(valeur);
		System.out.println("Le montant inscrit dans le modele par la vue est " + valeur);
		
		//return montantArgent;
	}
	
	public String getDevise()
	{
		return (String)selecteurDevises.getSelectedItem();
	}
	
	public void afficherMontantConverti()
	{
		resultatConversion.setText("" + this.montantArgent.getMontantConverti());
	}
	

}
