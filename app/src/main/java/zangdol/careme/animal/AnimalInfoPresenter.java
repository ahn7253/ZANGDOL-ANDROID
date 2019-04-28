package zangdol.careme.animal;

import zangdol.careme.model.Animal;
import zangdol.careme.restapi.GetAnimalInfo;

public class AnimalInfoPresenter implements AnimalInfoContract.Presenter,GetAnimalInfo.OnAnimalInfoListener {

    private AnimalInfoActivity view;
    private GetAnimalInfo getAnimalInfo;
    public AnimalInfoPresenter(AnimalInfoActivity animalInfoActivity) {
        this.view = animalInfoActivity;
    }

    @Override
    public void getAnimalInfo() {
        getAnimalInfo = new GetAnimalInfo("9",this);
    }

    @Override
    public void OnAnimalInfo(Animal animal) {
        view.setAnimalInfo(animal);
    }
}