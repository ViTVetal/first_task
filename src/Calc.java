import java.util.*;

public class Calc {
	public boolean detector = false;
	private HashMap command_unary = new HashMap();
	private HashMap command_binary = new HashMap();
	
	public void fill_command(double fir){
		command_unary.put("!", fact(fir));
		command_unary.put("sin", sin(fir));
		command_unary.put("cos", cos(fir));
		command_unary.put("sqrt", sqrt(fir));
	}
	public void fill_command(double fir, double sec){
		command_binary.put("+", add(fir, sec));
		command_binary.put("-", sub(fir, sec));
		command_binary.put("*", mult(fir, sec));
		command_binary.put("/", div(fir, sec));
		command_binary.put("^", degr(fir, sec));
	}
	public double read(String tas){
		if(command_unary.get(tas)!=null){
			detector = true;
			return (double)command_unary.get(tas);
		}
		else if(command_binary.get(tas)!=null){
			detector = true;
			return (double)command_binary.get(tas);
		}
		else{
			detector = false;
			return 0;
		}
	}

	public void command_clear(){
		command_unary.clear();
		command_binary.clear();
	}

	public double add(double fir, double sec){
		return fir + sec;
	}
	
	public double sub(double fir, double sec){
		return fir - sec;
	}
	
	public double mult(double fir, double sec){
		return fir * sec;
	}
	
	public double div(double fir, double sec){
		return fir / sec;
	}
	
	public double degr(double fir, double sec){
		return Math.pow(fir, sec);
	}
	
	public double sin(double fir){
		return Math.sin(fir);
	}
	
	public double cos(double fir){
		return Math.cos(fir);
	}
	
	public double sqrt(double fir){
		return Math.sqrt(fir);
	}
	
	public double fact(double fir){
		if (fir == 0) 
			return 1;
        
		return fir * fact(fir - 1);
	}
	
	public boolean overflow(double fir){
		if(fir == Double.POSITIVE_INFINITY || fir == Double.NEGATIVE_INFINITY ){
			System.out.println("Переполнение! Обнулено");
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean getDetector(){
		return detector;
	}
	
	public static void main(String[] args) {		
		Calc Action = new Calc();
		
		double first, second; 
		String task;
		
		Scanner scanner =new Scanner(System.in);
		
		while(true){
			try{
			first = scanner.nextDouble();
			Action.fill_command(first);
			task = scanner.next();
			Action.read(task);
			if(Action.getDetector()){
					first = Action.read(task);
					Action.command_clear();
					
					if(Action.overflow(first))
						continue;
					
					System.out.println(first);
				}
				else{
					second = scanner.nextDouble();
					Action.fill_command(first, second);
					Action.read(task);
					
					if(Action.getDetector()){
						first = Action.read(task);
						Action.command_clear();
						
						if(Action.overflow(first))
							continue;
					
						System.out.println(first);
					}
					else{
						System.out.println("Неизвестная команда");
						continue;
					}
				}
				while(true){
					task = scanner.next();
					
					if(task.equals("null")){
						System.out.println("Обнулено");
						break;
					}
					
					Action.fill_command(first);
					Action.read(task);
					
					if(Action.getDetector()){
						first = Action.read(task);
						Action.command_clear();
						
						if(Action.overflow(first))
							break;
						
						System.out.println(first);
						continue;
					}
					
					second = scanner.nextDouble();
					Action.fill_command(first, second);
					Action.read(task);
					
					if(Action.getDetector()){
						first = Action.read(task);
						Action.command_clear();
						
						if(Action.overflow(first))
							break;
						
						System.out.println(first);
					}
					else{
						System.out.println("Неизвестная команда");
						break;
					}
				}
			}
			catch(Exception e){
				System.out.println("Некоректные данные");
				scanner.next();
				continue;
			}
		}
	}
}
