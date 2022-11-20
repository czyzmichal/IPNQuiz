import re
import random
import json
class QuestionMaker:
    def getQuestionForSentance(self,sentance,difficulty):
        if difficulty == 0:
            match = re.findall('[1-2][0-9]{3}', sentance)
            answers = [match[0]]
            for i in range(3):
                answers.append(random.randint(int(match[0])-10, int(match[0])+10))
            return {'question':sentance.replace(match[0],'......'),'responses':answers}
        elif difficulty == 1:
            return {'question':sentance,'responses':[]}

    def getSentencesForPhrasesAndDifficulty(self,input,phrases,difficulty):
        f = open(input+'.json')
        dict = json.load(f)
        questions = []
        for phrase in phrases:
            if difficulty == 0:
                for sentence in dict[phrase]:
                    match = re.findall('[1][0-9]{3}', sentence)
                    if len(match)>1:
                        
                        questions.append(self.getQuestionForSentance(sentence,difficulty))
        return questions
            

print(QuestionMaker().getSentencesForPhrasesAndDifficulty("piłsudski",['Józefa Piłsudskiego'],0))