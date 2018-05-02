
public class PhoneNumberValidator {
	
	public boolean isValidPhoneNumber(String sequence){
		return isCorrectLenght(sequence) && !containsNonNumbers(sequence);
	}
	
	public boolean containsNonNumbers(String sequence){
		return sequence.contains("*") || sequence.contains("#");
	}
	
	public boolean isCorrectLenght(String sequence){
		return sequence.length()==10;
	}
	
	public boolean isValidDigit(char c){
		return c!='*' && c!='#';
	}
}
