package ingrauleduardop.demo.soapweb_service.data;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ingrauleduardop.demo.soap_ws.model.debitcards.DebitCard;


@Component
public class DebitCardRepository {
	private static final Map<String, DebitCard> debitCards = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		DebitCard debitCardOne = new DebitCard();
		debitCardOne.setNumeroTarjeta("1235698745");
		debitCardOne.setTipoUsuario("TITULAR");
		debitCardOne.setCodigoEstado("1");
		debitCardOne.setCodigoBloqueo("");
		debitCardOne.setNombreBloqueo("");
		
		debitCards.put(debitCardOne.getNumeroTarjeta(), debitCardOne);
		
		DebitCard debitCardTwo = new DebitCard();
		debitCardTwo.setNumeroTarjeta("7235698745");
		debitCardTwo.setTipoUsuario("ADICIONAL");
		debitCardTwo.setCodigoEstado("0");
		debitCardTwo.setCodigoBloqueo("N");
		debitCardTwo.setNombreBloqueo("Bloqueada por exceso de límite");
		
		debitCards.put(debitCardTwo.getNumeroTarjeta(), debitCardTwo);

	}
	
	public DebitCard findDebitCardByNumber(String cardNumber) {
		System.out.println("Tarjeta Solicitada: "+ cardNumber);
		return debitCards.get(cardNumber);
	}

}
