package ingrauleduardop.demo.soapweb_service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ingrauleduardop.demo.soap_ws.model.debitcards.GetDebitCardRequest;
import com.ingrauleduardop.demo.soap_ws.model.debitcards.GetDebitCardResponse;

import ingrauleduardop.demo.soapweb_service.data.DebitCardRepository;

@Endpoint
public class DebitCardEndpoint {

	private static final String NAMESPACE_URI = "http://ingrauleduardop.com/demo/soap-ws/model/debitCards";
	
	private DebitCardRepository debitCardRepository;
	
	@Autowired
	public DebitCardEndpoint(DebitCardRepository debitCardRepository) {
		this.debitCardRepository = debitCardRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart= "getDebitCardRequest")
	@ResponsePayload
	public GetDebitCardResponse getDebitCard(@RequestPayload GetDebitCardRequest getDebitCardRequest) {
		GetDebitCardResponse getDebitCardResponse = new GetDebitCardResponse();
		getDebitCardResponse.setDebitCard(debitCardRepository.findDebitCardByNumber(getDebitCardRequest.getNumeroTarjeta()));
		return getDebitCardResponse;
	}

}
