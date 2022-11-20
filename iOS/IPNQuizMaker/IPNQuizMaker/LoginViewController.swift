//
//  LoginViewController.swift
//  IPNQuizMaker
//
//  Created by Rdm on 19/11/2022.
//

import UIKit


var userLogin: String = "Radoslaw"
var userPassword: String = "pass123"

class LoginViewController: UIViewController {

    @IBOutlet weak var loginTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var forgottenPasswordButton: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        setUpTextField()
    }
    
    
    @IBAction func forgottenPasswordTapped(_ sender: UIButton) {
        print("bbbbś")
    }
        
  
    @IBAction func loginTapped(_ sender: UIButton) {
        print("loginTapped")
    }
    
    @IBAction func createAccountTapped(_ sender: UIButton) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let createAccVc = storyboard.instantiateViewController(withIdentifier: "createAccVc")
        
        createAccVc.modalPresentationStyle = .fullScreen
        
        DispatchQueue.main.async {
            self.present(createAccVc, animated: true, completion: nil)
        }
    }
    
    @IBAction func cancelTapped(_ sender: UIButton) {
        DispatchQueue.main.async {
            self.dismiss(animated: true)
        }
    }
    
    
    func validateUser(login: String, password: String) {
        if login == userLogin, password == userPassword {
            
            DispatchQueue.main.async {
                self.dismiss(animated: true)
            }
        }
    }
    
    func setUpTextField() {
        
        loginTextField.delegate = self
        passwordTextField.delegate = self
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension LoginViewController: UITextFieldDelegate {
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
}
