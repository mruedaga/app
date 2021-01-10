package mn.easyfeedback.core

interface UseCase<I, O> {

    O execute( I input )

}