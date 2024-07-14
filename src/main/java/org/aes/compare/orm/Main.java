package org.aes.compare.orm;

import org.aes.compare.orm.config.ORMConfigSingleton;
import org.aes.compare.orm.consoleapplication.AddressFacade;
import org.aes.compare.orm.consoleapplication.CourseFacade;
import org.aes.compare.orm.consoleapplication.ExamResultFacade;
import org.aes.compare.orm.consoleapplication.StudentFacade;
import org.aes.compare.uiconsole.utility.SafeScannerInput;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ORMConfigSingleton orm = new ORMConfigSingleton();
    //    static SubaddressFacade addressFacade = new SubaddressFacade(orm.getAddressService());
    static AddressFacade addressFacade;// = new addressFacadeFacade(orm.getAddressService());
    static StudentFacade studentFacade;// = new studentFacadeFacade(orm.getStudentService(), orm.getAddressService());
    static CourseFacade courseFacade;
    static ExamResultFacade examResultFacade;


    public static void main(String[] args) {
        ORMConfigSingleton.enableJPA();
//        ORMConfigSingleton.enableHibernate();
        addressFacade = new AddressFacade(orm.getAddressService());
        courseFacade = new CourseFacade(orm.getCourseService());
        studentFacade = new StudentFacade(orm.getStudentService(),addressFacade,courseFacade);
        examResultFacade = new ExamResultFacade(orm.getExamResultService(), orm.getStudentService(), orm.getCourseService(),studentFacade);


/*

//        List<Address> tmpAddress = orm.getAddressService().findAllSavedAndNotMatchedAnyStudentAddress();
//        tmpAddress.forEach(System.out::println);

        int studentId=2;
        List<Course> tmpCourse = orm.getCourseService().findAllCourseOfStudentId(studentId);
        System.out.println("Student have : ");
        tmpCourse.forEach(System.out::println);

        tmpCourse = orm.getCourseService().findAllCourseThatStudentDoesNotHave(studentId);
        System.out.println("Student does not have : ");
        tmpCourse.forEach(System.out::println);

        System.exit(0);
*/

        int globalOption = -1;
        while (globalOption != 5) {
            System.out.println("1-) Address");
            System.out.println("2-) Student");
            System.out.println("3-) Course");
            System.out.println("4-) ExamResult");
            System.out.println("5-) Exit Program");
//            System.out.print("Type one of the number :");
//            globalOption = scanner.nextInt();
            globalOption = SafeScannerInput.getCertainIntForSwitch("Type one of the number :",1,5);

            switch (globalOption) {
                case 1:
                    System.out.println("Leads to Address Process");
                    addressScenario();
                    break;
                case 2:
                    System.out.println("Leads to Student Process");
                    studentScenario();
                    break;
                case 3:
                    System.out.println("Leads to Course Process");
                    courseScenario();
                    break;
                case 4:
                    System.out.println("Leads to Exam Result Process");
                    examResultScenario();
                    break;
                case 5:
                    System.out.println("Exitting the program");
                    break;
                default:
                    System.out.println("Invalid choose please try again!");
            }
        }

    }

    static void addressScenario() {
        int option = -1;
        while (option != 6) {
            System.out.println("1-) Save");
            System.out.println("2-) Find All");
            System.out.println("3-) Find By Id");
            System.out.println("4-) Update");
            System.out.println("5-) Delete");
            System.out.println("6-) Exit");

            System.out.println("select one option");
            option = SafeScannerInput.getCertainIntSafe();
//            scanner.nextLine();

            switch (option) {
                case 1:
                    addressFacade.save();
                    break;
                case 2:
                    addressFacade.findAll();
                    break;
                case 3:
                    addressFacade.findById();
                    break;
                case 4:
                    addressFacade.update();
                    break;
                case 5:
                    addressFacade.delete();
                    break;
                case 6:
                    System.out.println("exitting the address Service");
                    break;
                default:
                    System.out.println("Invalid Choose try again");
            }
        }
    }

    static void studentScenario() {
        int option = -1;
        while (option != 7) {
            System.out.println("1-) Save");
            System.out.println("2-) Find All");
            System.out.println("3-) Find By Id");
            System.out.println("4-) Find By Student Id And Course Name");
            System.out.println("5-) Update");
            System.out.println("6-) Delete");
            System.out.println("7-) Exit");

            System.out.println("select one option");
            option = SafeScannerInput.getCertainIntSafe();
//            scanner.nextLine();

            switch (option) {
                case 1:
                    studentFacade.save();
                    break;
                case 2:
                    studentFacade.findAll();
                    break;
                case 3:
                    studentFacade.findByMultipleWay();
                    break;
                case 4:
                    studentFacade.findByStudentIdWithCourseName();
                    break;
                case 5:
                    studentFacade.update();
                    break;
                case 6:
                    studentFacade.delete();
                    break;
                case 7:
                    System.out.println("Exiting the Student Service");
                    break;
                default:
                    System.out.println("Invalid Choose try again");
            }
        }
    }

    static void courseScenario() {
        int option = -1;
        while (option != 6) {
            System.out.println("1-) Save");
            System.out.println("2-) Find All");
            System.out.println("3-) Find By Name");
            System.out.println("4-) Update");
            System.out.println("5-) Delete");
            System.out.println("6-) Exit");

            System.out.println("Select one option");
            option = SafeScannerInput.getCertainIntSafe();
//            scanner.nextLine();

            switch (option) {
                case 1:
                    courseFacade.save();
                    break;
                case 2:
                    courseFacade.findAll();
                    break;
                case 3:
                    courseFacade.findByName();
                    break;
                case 4:
                    courseFacade.update();
                    break;
                case 5:
                    courseFacade.delete();
                    break;
                case 6:
                    System.out.println("Exiting the Course Service");
                    break;
                default:
                    System.out.println("Invalid Choose try again");
            }
        }
    }

    static void examResultScenario() {
        int option = -1;
        while (option != 8) {
            System.out.println("1-) Save");
            System.out.println("2-) Find All");
            System.out.println("3-) Find All By Student (Id)");
            System.out.println("4-) Find All By Course (Name)");
            System.out.println("5-) Find All By Student (Id) And Course (Name)");
            System.out.println("6-) Update");
            System.out.println("7-) Delete");
            System.out.println("8-) Exit");

            System.out.println("Select one option");
            option = SafeScannerInput.getCertainIntSafe();
//            scanner.nextLine();

            switch (option) {
                case 1:
                    examResultFacade.save();
                    break;
                case 2:
                    examResultFacade.findAll();
                    break;
                case 3:
                    examResultFacade.findAllByStudentId();
                    break;
                case 4:
                    examResultFacade.findAllByCourseName();
                    break;
                case 5:
                    examResultFacade.findAllByStudentIdAndCourseName();
                    break;
                case 6:
                    examResultFacade.update();
                    break;
                case 7:
                    examResultFacade.delete();
                    break;
                case 8:
                    System.out.println("Exiting the Exam Result Service");
                    break;
                default:
                    System.out.println("Invalid Choose try again");
            }
        }
    }

    /*static class SubaddressFacade {
        private final AddressService addressService;
        private static int counter = 0;

        public SubaddressFacade(AddressService addressService) {
            this.addressService = addressService;
        }

        public void save() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorTextWithPrefix(counter + "-) [ADDRESS] Save : "));
            Address address = new Address();
            address.setCity(counter + ". City");
            address.setStreet(counter + ". Street");
            address.setCountry(counter + ". Counter");


            addressService.save(address);
            System.out.println("Address is saved : " + address);
            System.out.println("----------------------------------");
        }

        public void findById() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorTextWithPrefix(counter + "-) [ADDRESS] Find by id : "));
            System.out.print("Id no: ");
//            int id = scanner.nextInt();
            int id = SafeScannerInput.getCertainIntSafe();
            Address address = addressService.findById(id);
            addressService.findById(id);
            System.out.println("Address is Found: " + address);
            System.out.println("----------------------------------");

        }

        public void findAll() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorTextWithPrefix(counter + "-) [ADDRESS] Find ALL : "));
            List<Address> addresses = addressService.findAll();
//            System.out.println("Addresses Found: " + addresses);
            addresses.forEach(e -> {
                System.out.println(e);
            });
            System.out.println("----------------------------------");

        }

        public void update() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorTextWithPrefix(counter + "-) [ADDRESS] Update : "));
            System.out.print("Address Id no: ");
//            int id = scanner.nextInt();
            int id = SafeScannerInput.getCertainIntSafe();
            Address address = addressService.findById(id);
            addressService.findById(id);
            System.out.println("Address is Found: " + address);
            System.out.println("Update process is starting : ");


            int selected = 0;
            while (selected != 4) {
                System.out.println("1-) City");
                System.out.println("2-) Street");
                System.out.println("3-) Country");
                System.out.println("4-) Update and Exit");

                System.out.println("Current address data : ");
                System.out.println(address);
                selected = scanner.nextInt();
                scanner.nextLine();
                switch (selected) {
                    case 1:
                        System.out.print("Type City to update :");
                        address.setCity(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Type Street to update :");
                        address.setStreet(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Type Country to update :");
                        address.setCountry(scanner.nextLine());
                        break;
                    case 4:
                        addressService.update(address);
                        System.out.println("Address is updated : " + address);
                        break;
                    default:
                        System.out.println("Invalid choice try again");
                }
            }
            System.out.println("----------------------------------");
        }

        public void deleteById() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorTextWithPrefix(counter + "-) [ADDRESS] Delete By Id : "));
            System.out.print("Id no: ");
            int id = scanner.nextInt();
            Address address = addressService.findById(id);
            addressService.findById(id);
            System.out.println("Address is Found: " + address);
            addressService.deleteById(id);
            System.out.println("address is deleted : ");
            System.out.println("----------------------------------");

        }

        public void resetTable() {
        }
    }*/


}