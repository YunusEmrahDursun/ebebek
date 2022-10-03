package ebebek;

public class ebebek {

	
	public static void main(String[] args) {
		Employee calisan=new Employee("Ahmet KAYA",2000,45,1998);
		calisan.raiseSalary();
		System.out.println(calisan.toString());

	}

}

class Employee{
	
		private String name;
		private Integer salary;
		private Integer workHours;
		private Integer hireYear;
	
		public static Integer currentYear=2021;
		
		private Integer oldSalary=0;
		private Integer taxed=0;
		private Integer increased=0;
		
		public Employee(String name, Integer salary, Integer workHours, Integer hireYear) {
			this.name = name;
			this.salary = salary;
			this.workHours = workHours;
			this.hireYear = hireYear;
		}
		
		private Integer tax() {
			if(this.salary>=1000) {
				return (this.salary*3)/100;
			}
			return 0;
		}
		
		private Integer bonus() {
			if(this.workHours>40) {
				return (this.workHours-40) * 30;
			}
			return 0;
		}
		
		public void raiseSalary() {
			this.oldSalary=this.salary;
			Integer workedYear=Employee.currentYear-this.hireYear;
			Integer result=0;
			if( workedYear<10 ) {
				result = (this.salary*5)/100; 
			}
			else if( workedYear>9 && 20>workedYear ) {
				result = (this.salary*10) /100;
			}
			else if( workedYear>19 ) {
				result = (this.salary*15)/100;
			}
			this.increased=result;
			this.salary=result+this.bonus()+this.salary;
			this.taxed=this.tax();
			this.salary=this.salary+this.taxed;
		}
		
		public String toString()  {
			return 
					   " Isim Soyisim                     :"+this.name
					+"\n Maas                             :"+this.oldSalary
					+"\n Calisma Saati                    :"+this.workHours
					+"\n Baslangic Yili                   :"+this.hireYear
					+"\n Vergi                            :"+this.taxed
					+"\n Bonus                            :"+this.bonus()
					+"\n Maas Artisi                      :"+this.increased 
					+"\n Vergi ve Bonuslarla              :"+(this.oldSalary+this.bonus()+this.taxed)
					+"\n Toplam                           :"+this.salary;
			
		}
		
		
}

	

