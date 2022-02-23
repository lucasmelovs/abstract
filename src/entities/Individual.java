package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healExpenditures) {
		this.healthExpenditures = healExpenditures;
	}

	@Override
	public Double tax() {
		if(anualIncome < 20000) {
			anualIncome = anualIncome * 0.15 - healthExpenditures/2;
		}else {
			anualIncome = anualIncome * 0.25 - healthExpenditures/2;
		}
		return anualIncome;
	}

}
