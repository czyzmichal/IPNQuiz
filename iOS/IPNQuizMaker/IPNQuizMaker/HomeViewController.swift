//
//  HomeViewController.swift
//  IPNQuizMaker
//
//  Created by Rdm on 19/11/2022.
//

import UIKit

struct Quiz: Decodable {
    
    var name: String
    var creationDate: String
    
}

class HomeViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var createNewQuizView: UIView!
    @IBOutlet weak var plusBgView: UIView!
    @IBOutlet weak var personBgView: UIView!
    @IBOutlet weak var teacherDataBgView: UIView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        setUpTableView()
        setUpAppearance()
 
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        
        DispatchQueue.main.async {
            self.tableView.reloadData()
        }
        

    }
    
    @IBAction func createNewQuizTapped(_ sender: UIButton) {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let nextVc = storyboard.instantiateViewController(withIdentifier: "newQuizVc") as! CreateQuizViewController
        print("tappedd")
        DispatchQueue.main.async {
            self.navigationController?.pushViewController(nextVc, animated: true)
        }
    }
    
//    func setUpGestureRecognizer() {
//        let tapGesture = UITapGestureRecognizer()
//
//        tapGesture.numberOfTapsRequired = 1
//        tapGesture.addTarget(self, action: #selector(addQuizTapped))
//
//        plusBgView.addGestureRecognizer(tapGesture)
//    }
    
    func setUpAppearance() {
        createNewQuizView.setCornerRadius(value: 6)
        plusBgView.setCornerRadius(value: 12)
        personBgView.setCornerRadius(value: personBgView.frame.size.height / 2)
        teacherDataBgView.setCornerRadius(value: 12)
    }

    func setUpTableView() {
        self.tableView.delegate = self
        self.tableView.dataSource = self
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

extension HomeViewController: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        5
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 74
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "quizCell", for: indexPath) as! QuizCell
        
        cell.setUpAppearance()
        cell.selectionStyle = .none
        
        return cell
    }
    
}

extension UIView {
    
    func setCornerRadius(value: CGFloat) {
        self.layer.masksToBounds = false
        self.layer.cornerRadius = value
    }
    
    func setBorderLine(value: CGFloat, color: CGColor) {
        self.layer.masksToBounds = false
        self.layer.borderColor = color
    }
    
}
