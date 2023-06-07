package ru.rrenat358;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    @Value("#{19 + 1}") // 20
    private double add;

    @Value("#{'String1 ' + 'string2'}") // "String1 string2"
    private String addString;

    @Value("#{20 - 1}") // 19
    private double subtract;

    @Value("#{10 * 2}") // 20
    private double multiply;

    @Value("#{36 / 2}") // 19
    private double divide;

    @Value("#{36 div 2}") // 18, the same as for / operator
    private double divideAlphabetic;

    @Value("#{37 % 10}") // 7
    private double modulo;

    @Value("#{37 mod 10}") // 7, the same as for % operator
    private double moduloAlphabetic;

    @Value("#{2 ^ 9}") // 512
    private double powerOf;

    @Value("#{(2 + 2) * 2 + 9}") // 17
    private double brackets;

    @Value("#{1 == 1}") // true
    private boolean equal;

    @Value("#{1 eq 1}") // true
    private boolean equalAlphabetic;

    @Value("#{1 != 1}") // false
    private boolean notEqual;

    @Value("#{1 ne 1}") // false
    private boolean notEqualAlphabetic;

    @Value("#{1 < 1}") // false
    private boolean lessThan;

    @Value("#{1 lt 1}") // false
    private boolean lessThanAlphabetic;

    @Value("#{1 <= 1}") // true
    private boolean lessThanOrEqual;

    @Value("#{1 le 1}") // true
    private boolean lessThanOrEqualAlphabetic;

    @Value("#{1 > 1}") // false
    private boolean greaterThan;

    @Value("#{1 gt 1}") // false
    private boolean greaterThanAlphabetic;

    @Value("#{1 >= 1}") // true
    private boolean greaterThanOrEqual;

    @Value("#{1 ge 1}") // true
    private boolean greaterThanOrEqualAlphabetic;

    @Value("#{250 > 200 && 200 < 4000}") // true
    private boolean and;

    @Value("#{250 > 200 and 200 < 4000}") // true
    private boolean andAlphabetic;

    @Value("#{400 > 300 || 150 < 100}") // true
    private boolean or;

    @Value("#{400 > 300 or 150 < 100}") // true
    private boolean orAlphabetic;

    @Value("#{!true}") // false
    private boolean not;

    @Value("#{not true}") // false
    private boolean notAlphabetic;

    @Value("#{2 > 1 ? 'a' : 'b'}") // "a"
    private String ternary1;

//    @Value("#{someBean.someProperty != null ? someBean.someProperty : 'default'}")
//    private String ternary2;
//
//    @Value("#{someBean.someProperty ?: 'default'}") // Will inject provided string if someProperty is null
//    private String elvis;

//    @Component("workersHolder")
//    public class WorkersHolder {
//        private List<String> workers = new LinkedList<>();
//        private Map<String, Integer> salaryByWorkers = new HashMap<>();
//
//        public WorkersHolder() {
//            workers.add("John");
//            workers.add("Susie");
//            workers.add("Alex");
//            workers.add("George");
//
//            salaryByWorkers.put("John", 35000);
//            salaryByWorkers.put("Susie", 47000);
//            salaryByWorkers.put("Alex", 12000);
//            salaryByWorkers.put("George", 14000);
//        }
//
//        //Getters and setters
//    }

//    @Value("#{workersHolder.salaryByWorkers['John']}") // 35000
//    private Integer johnSalary;
//
//    @Value("#{workersHolder.salaryByWorkers['George']}") // 14000
//    private Integer georgeSalary;
//
//    @Value("#{workersHolder.salaryByWorkers['Susie']}") // 47000
//    private Integer susieSalary;
//
//    @Value("#{workersHolder.workers[0]}") // John
//    private String firstWorker;
//
//    @Value("#{workersHolder.workers[3]}") // George
//    private String lastWorker;
//
//    @Value("#{workersHolder.workers.size()}") // 4
//    private Integer numberOfWorkers;
}
