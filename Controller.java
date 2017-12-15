public class Controller {
	
	private PersonRegister register;
	
	public Controller(PersonRegister register) {
		this.register = register;
	}
	
	public Person addPerson(String pNbr, String name) {
		Person p = new Person();
		p.setPNbr(pNbr);
		p.setName(name);
		
		this.register.add(p);
		
		return p;
	}
	
	public Person findPerson(String pNbr) {
		Person p = this.register.find(pNbr);
		if (p != null) {
			return p;
		} 
		return null;
	}
	
	public Person removePerson(String pNbr) {
		Person p = this.register.remove(pNbr);
		if (p != null) {
			return p;
		}
		return null;
	}
	
	public BankAccount addBankAccount(String nbr, String pNbr) {
		Person p = this.register.find(pNbr);
		if (p != null) {
			BankAccount a = new BankAccount();
			a.setNbr(nbr);
			
			p.add(a);
			a.setOwner(p);
			
			return a;
		}
		return null;
	}
	
	public String getAccounts(String pNbr) {
		Person p = this.register.find(pNbr);
		if (p != null) {
			if (p.getAccounts().size() == 0) {
				return "Person " + p.getName() + " has no bank accounts.";
			}
			
			String lineBreak = System.getProperty("line.separator");
			String entry = "";
			for (BankAccount a : p.getAccounts()) {
				entry += "Number: " + a.getNbr() + ", balance: " + a.getBalance() + lineBreak;
			}
			return entry;
		}
		return "Person with social security number " + pNbr + " doesn't exist.";
	}

}
