//
//  QuizCell.swift
//  IPNQuizMaker
//
//  Created by Rdm on 20/11/2022.
//

import UIKit

class QuizCell: UITableViewCell {
    
    @IBOutlet weak var quizNameLabel: UILabel!
    @IBOutlet weak var creationDateLabel: UILabel!
    @IBOutlet weak var containerView: UIView!
    @IBOutlet weak var plusIconBgView: UIView!
    
    var quiz: Quiz?
    
    override func awakeFromNib() {
        super.awakeFromNib()
      
    }

    override func layoutSubviews() {
        super.layoutSubviews()
        
        contentView.frame = contentView.frame.inset(by: UIEdgeInsets(top: 2, left: 0, bottom: 2, right: 0))
        
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setUpAppearance() {
        containerView.setCornerRadius(value: 6)
        plusIconBgView.setCornerRadius(value: 4)
    }

}
