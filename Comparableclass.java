

	import java.util.*;
	public class Comparableclass {
		
		public static void main(String[] args) {
			List<Patient> patients = new ArrayList<>();
			
			patients.add(new Patient(21,new Date("05/08/2018"),"xyz"));
			patients.add(new Patient(14,new Date("21/03/2018"),"abc"));
			patients.add(new Patient(13,new Date("17/05/2018"),"pqr"));
			
			Collections.sort(patients, new Comparator<Patient>() {

				@Override
				public int compare(Patient o1, Patient o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			for (int i = 0; i < patients.size(); i++) {
				System.out.println(patients.get(i).getAppointmentTime()+":"+patients.get(i).getName());
				
			}
			
			Collections.sort(patients, new sortbydate());
			for (int i = 0; i < patients.size(); i++) {
				System.out.println(patients.get(i).getAppointmentTime()+":"+patients.get(i).getName()+":"+patients.get(i).getAge());
				
			}
			Collections.sort(patients, new sortbyage());

			for (int i = 0; i < patients.size(); i++) {
				System.out.println(patients.get(i).getAppointmentTime()+":"+patients.get(i).getAge());
				
			}
		}

	}

	class sortbydate implements Comparator<Patient>{
	    public int compare(Patient o1,Patient o2){
	        return o1.getAppointmentTime().compareTo(o2.getAppointmentTime());
	    }
	}

	class sortbyage implements Comparator<Patient>{
	    public int compare(Patient o1, Patient o2){
	        return o1.getAge() > o2.getAge()? 1:-1;
	    }
	}



	class Patient implements Comparable<Patient>{
		Date appointmentTime;
		String name;
		int age;
		public Patient(int age,Date appointmentTime, String name) {
			super();
			this.appointmentTime = appointmentTime;
			this.name = name;
			this.age =age;
		}
		public int getAge(){
		    return age;
		}
		public Date getAppointmentTime() {
			return appointmentTime;
		}
		public void setAppointmentTime(Date appointmentTime) {
			this.appointmentTime = appointmentTime;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(){
		    this.age = age;
		}
		@Override
		public int compareTo(Patient o) {
			return (int) (this.getAppointmentTime().getTime()-o.getAppointmentTime().getTime());
		}
		
		
	}
