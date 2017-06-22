/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCRUD;

import java.io.File;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author seekc
 */
@WebService(serviceName = "PatientCRUD")
public class PatientCRUD {

    /**
     * This is a Add web service operation
     * 
     * * @param value
     */
    
    // Inserting node using xerces with DOM
    @WebMethod(operationName = "Add")
    public String Add(String filecode, String firstname, String lastname, 
            String dob, String gender, String street, String city, 
            String cell, String home, String email, String medical, 
            String allergies, String bloodgroup, String occupation, 
            String employfirstname, String employlastname, String employwork, String employstreet, 
            String employcity, String emerfirstname, String emerlastname, 
            String emerstreet, String emercity, String emercell, 
            String emerhome, String emeremail ) throws Exception {
        
        File file = new File("C:/Users/seekc/OneDrive/Documentos/NetBeansProjects/PatientWs/src/java/PatientCRUD/patient.xml");
        // Create Document Builder Factory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        //  Create the parser
        DocumentBuilder db = docFactory.newDocumentBuilder();
        //open and parse XML-file
        Document doc = db.parse(file); // Retrieve the DOM document to populate 
        
        //Get Root xmlElement
        Element root = doc.getDocumentElement();//root        
        Element patients = doc.createElement("patients");//get element name
        root.appendChild(patients);

        Element filecodes = doc.createElement("filecode");// add root the root node
        patients.appendChild(filecodes);
        filecodes.setTextContent(filecode); // set text found in string
        
        Element firstnames = doc.createElement("firstname");
        patients.appendChild(firstnames);
        firstnames.setTextContent(firstname);
        
        Element lastnames = doc.createElement("lastname");
        patients.appendChild(lastnames);
        lastnames.setTextContent(lastname);
        
        Element genders = doc.createElement("gender");
        patients.appendChild(genders);
        genders.setTextContent(gender);

        Element dateOfBirth = doc.createElement("dob");
        patients.appendChild(dateOfBirth);
        dateOfBirth.setTextContent(dob);

        Element streets = doc.createElement("street");
        patients.appendChild(streets);
        streets.setTextContent(street);
        
        Element cit = doc.createElement("city");
        patients.appendChild(cit);
        cit.setTextContent(city);
        
        Element cells = doc.createElement("cell");
        patients.appendChild(cells);
        cells.setTextContent(cell);
        
        Element homes = doc.createElement("home");
        patients.appendChild(homes);
        homes.setTextContent(home);
        
        Element emails = doc.createElement("email");
        patients.appendChild(emails);
        emails.setTextContent(email);

        Element medicals = doc.createElement("medical");
        patients.appendChild(medicals);
        medicals.setTextContent(medical);
        
        Element allergiess = doc.createElement("allergies");
        patients.appendChild(allergiess);
        allergiess.setTextContent(allergies);
        
        Element bloodgroups = doc.createElement("bloodgroup");
        patients.appendChild(bloodgroups);
        bloodgroups.setTextContent(bloodgroup);
                
        Element occupations = doc.createElement("occupation");
        patients.appendChild(occupations);
        occupations.setTextContent(occupation);
        
        Element eefirstname = doc.createElement("employfirstname");
        patients.appendChild(eefirstname);
        eefirstname.setTextContent(employfirstname);
        
        Element eelastname = doc.createElement("employlastname");
        patients.appendChild(eelastname);
        eelastname.setTextContent(employlastname); 
        
        Element eworks = doc.createElement("employwork");
        patients.appendChild(eworks);
        eworks.setTextContent(employwork);
        
        Element estreets = doc.createElement("employstreet");
        patients.appendChild(estreets);
        estreets.setTextContent(employstreet);
        
        Element ecit = doc.createElement("employcity");
        patients.appendChild(ecit);
        ecit.setTextContent(employcity);

        Element emfirstnames = doc.createElement("emerfirstname");
        patients.appendChild(emfirstnames);
        emfirstnames.setTextContent(emerfirstname);
        
        Element emlastnames = doc.createElement("emerlastname");
        patients.appendChild(emlastnames);
        emlastnames.setTextContent(emerlastname); 
        
        Element emstreets = doc.createElement("emerstreet");
        patients.appendChild(emstreets);
        emstreets.setTextContent(emerstreet);
        
        Element emcitys = doc.createElement("emercity");
        patients.appendChild(emcitys);
        emcitys.setTextContent(emercity);
        
        Element emcells = doc.createElement("emercell");
        patients.appendChild(emcells);
        emcells.setTextContent(emercell);
        
        Element emhomes = doc.createElement("emerhome");
        patients.appendChild(emhomes);
        emhomes.setTextContent(emerhome);
        
        Element ememails = doc.createElement("emeremail");
        patients.appendChild(ememails);
        ememails.setTextContent(emeremail);
        
        DOMSource source = new DOMSource(doc); //
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
        
        return "Filecode= " + filecode + " is saved." ;
    }
    
    /**
     * This is a delete web service operation
     */
    @WebMethod(operationName = "Delete")
    public String Delete(String filecode) throws Exception {
        File file = new File("C:/Users/seekc/OneDrive/Documentos/NetBeansProjects/PatientWs/src/java/PatientCRUD/patient.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = docFactory.newDocumentBuilder();
        Document doc = db.parse(file);
        NodeList patNode = doc.getElementsByTagName("patient");
        NodeList patNode2 = doc.getElementsByTagName("patients");
        for (int i = 0; i < patNode2.getLength(); i++) {
            Node nNode = patNode.item(0);
            Node nNode2 = patNode2.item(i);
            Element eElement2 = (Element) nNode2;

            if (eElement2.getElementsByTagName("filecode").item(0).getTextContent().equals(filecode)) {
                nNode.removeChild(nNode2);
            }
        }

        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
        return "Filecode = " + filecode + " has been deleted.";
   }


    /**
     * This is a update web service operation
     */


    @WebMethod(operationName = "Update")
    public String Update(String field, String search, String filecode, String firstname, 
            String lastname, String dob, String gender, String street, String city, 
            String cell, String home, String email, String medical, 
            String allergies, String bloodgroup, String occupation, 
            String employfirstname, String employlastname, String employwork, String employstreet, 
            String employcity, String emerfirstname, String emerlastname, 
            String emerstreet, String emercity, String emercell, 
            String emerhome, String emeremail) throws Exception {

        File file = new File("C:/Users/seekc/OneDrive/Documentos/NetBeansProjects/PatientWs/src/java/PatientCRUD/patient.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = docFactory.newDocumentBuilder();
        Document doc = db.parse(file);
        NodeList patNode = doc.getElementsByTagName("patients");
        for (int i = 0; i < patNode.getLength(); i++) {
            Node nNode = patNode.item(i);
            
            Node filecodes = doc.getElementsByTagName("filecode").item(i);                      
            Node firstnames = doc.getElementsByTagName("firstname").item(i);                       
            Node lastnames = doc.getElementsByTagName("lastname").item(i);                        
            Node date = doc.getElementsByTagName("dob").item(i);
            Node genders = doc.getElementsByTagName("gender").item(i);
            Node streets = doc.getElementsByTagName("street").item(i);
            Node citys = doc.getElementsByTagName("city").item(i);             
            Node cells = doc.getElementsByTagName("cell").item(i);
            Node homes = doc.getElementsByTagName("home").item(i);            
            Node emails = doc.getElementsByTagName("email").item(i);
            Node medicals = doc.getElementsByTagName("medical").item(i);
            Node allergy = doc.getElementsByTagName("allergies").item(i);
            Node bloodgroups = doc.getElementsByTagName("bloodgroup").item(i);
            Node occupations = doc.getElementsByTagName("occupation").item(i);
            Node employfirstnames = doc.getElementsByTagName("employfirstname").item(i);
            Node employlastnames = doc.getElementsByTagName("employlastname").item(i);
            Node employworks = doc.getElementsByTagName("employwork").item(i);
            Node employstreets = doc.getElementsByTagName("employstreet").item(i);
            Node employcitys = doc.getElementsByTagName("employcity").item(i);
            Node emerfirstnames = doc.getElementsByTagName("emerfirstname").item(i);
            Node emerlastnames = doc.getElementsByTagName("emerlastname").item(i);
            Node emerstreets = doc.getElementsByTagName("emerstreet").item(i);
            Node emercitys = doc.getElementsByTagName("emercity").item(i);
            Node emercells = doc.getElementsByTagName("emercell").item(i);
            Node emerhomes = doc.getElementsByTagName("emerhome").item(i);
            Node emeremails = doc.getElementsByTagName("emeremail").item(i);
           
            Element eElement = (Element) nNode;
            if (eElement.getElementsByTagName(field).item(0).getTextContent().equals(search)) {
                filecodes.setTextContent(filecode);
                firstnames.setTextContent(firstname); 
                lastnames.setTextContent(lastname);
                date.setTextContent(dob);
                genders.setTextContent(gender);
                streets.setTextContent(street);
                citys.setTextContent(city);
                cells.setTextContent(cell);
                homes.setTextContent(home);
                emails.setTextContent(email);
                medicals.setTextContent(medical);
                allergy.setTextContent(allergies);
                bloodgroups.setTextContent(bloodgroup);             
                occupations.setTextContent(occupation);
                employfirstnames.setTextContent(employfirstname);
                employlastnames.setTextContent(employlastname);
                employworks.setTextContent(employwork);
                employstreets.setTextContent(employstreet);
                employcitys.setTextContent(employcity);
                emerfirstnames.setTextContent(emerfirstname);
                emerlastnames.setTextContent(emerlastname);
                emerstreets.setTextContent(emerstreet);
                emercitys.setTextContent(emercity);
                emercells.setTextContent(emercell);
                emerhomes.setTextContent(emerhome);
                emeremails.setTextContent(emeremail);
            }
        }
        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
        return "Filecode:" + filecode + " has been modified.";

    }   
    /**
     * This is a search web service operation
     */
    //

    @WebMethod(operationName = "Search")
    public String search(String field, String search) throws Exception { //passing 2 parameters
        File file = new File("C:/Users/seekc/OneDrive/Documentos/NetBeansProjects/PatientWs/src/java/PatientCRUD/patient.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        NodeList patNode = doc.getElementsByTagName("patients");
        String results = "";//return value nu bizin
        for (int i = 0; i < patNode.getLength(); i++) {//read xml file  employ
            Node nNode = patNode.item(i);//read node elements
            Element eElement = (Element) nNode;
            if (field.equals("") && search.equals("")) { //compare value entered in the search methods
                results = results  + eElement.getElementsByTagName("filecode").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("firstname").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("lastname").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("dob").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("gender").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("street").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("city").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("cell").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("home").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("email").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("medical").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("allergies").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("bloodgroup").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("occupation").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("employfirstname").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("employlastname").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("employwork").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("employstreet").item(0).getTextContent()                        
                        + "*" + eElement.getElementsByTagName("employcity").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emerfirstname").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("emerlastname").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emerstreet").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("emercity").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emercell").item(0).getTextContent()
                        + "*"+ eElement.getElementsByTagName("emerhome").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emeremail").item(0).getTextContent()
                        +"#";
            }else if (eElement.getElementsByTagName(field).item(0).getTextContent().equals(search)) {
                results = results  + eElement.getElementsByTagName("filecode").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("firstname").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("lastname").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("dob").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("gender").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("street").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("city").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("cell").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("home").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("email").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("medical").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("allergies").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("bloodgroup").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("occupation").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("employfirstname").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("employlastname").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("employwork").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("employstreet").item(0).getTextContent()                        
                        + "*" + eElement.getElementsByTagName("employcity").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emerfirstname").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("emerlastname").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emerstreet").item(0).getTextContent()
                        + "*" + eElement.getElementsByTagName("emercity").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emercell").item(0).getTextContent()
                        + "*"+ eElement.getElementsByTagName("emerhome").item(0).getTextContent() 
                        + "*" + eElement.getElementsByTagName("emeremail").item(0).getTextContent()
                        +"#";
            }
        }// end of for loop
        
        return results;
    }

}
