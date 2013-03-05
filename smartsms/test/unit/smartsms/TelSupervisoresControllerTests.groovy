package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(TelSupervisoresController)
@Mock(TelSupervisores)
class TelSupervisoresControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/telSupervisores/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.telSupervisoresInstanceList.size() == 0
        assert model.telSupervisoresInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.telSupervisoresInstance != null
    }

    void testSave() {
        controller.save()

        assert model.telSupervisoresInstance != null
        assert view == '/telSupervisores/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/telSupervisores/show/1'
        assert controller.flash.message != null
        assert TelSupervisores.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/telSupervisores/list'

        populateValidParams(params)
        def telSupervisores = new TelSupervisores(params)

        assert telSupervisores.save() != null

        params.id = telSupervisores.id

        def model = controller.show()

        assert model.telSupervisoresInstance == telSupervisores
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/telSupervisores/list'

        populateValidParams(params)
        def telSupervisores = new TelSupervisores(params)

        assert telSupervisores.save() != null

        params.id = telSupervisores.id

        def model = controller.edit()

        assert model.telSupervisoresInstance == telSupervisores
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/telSupervisores/list'

        response.reset()

        populateValidParams(params)
        def telSupervisores = new TelSupervisores(params)

        assert telSupervisores.save() != null

        // test invalid parameters in update
        params.id = telSupervisores.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/telSupervisores/edit"
        assert model.telSupervisoresInstance != null

        telSupervisores.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/telSupervisores/show/$telSupervisores.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        telSupervisores.clearErrors()

        populateValidParams(params)
        params.id = telSupervisores.id
        params.version = -1
        controller.update()

        assert view == "/telSupervisores/edit"
        assert model.telSupervisoresInstance != null
        assert model.telSupervisoresInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/telSupervisores/list'

        response.reset()

        populateValidParams(params)
        def telSupervisores = new TelSupervisores(params)

        assert telSupervisores.save() != null
        assert TelSupervisores.count() == 1

        params.id = telSupervisores.id

        controller.delete()

        assert TelSupervisores.count() == 0
        assert TelSupervisores.get(telSupervisores.id) == null
        assert response.redirectedUrl == '/telSupervisores/list'
    }
}
