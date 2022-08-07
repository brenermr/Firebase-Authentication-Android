package br.com.alura.aluraesporte.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth

private const val TAG = "FirebaseAuthRepository"

class FirebaseAuthRepository(private val auth: FirebaseAuth) {


    private fun logOff(auth: FirebaseAuth) {
        auth.signOut()
    }

    private fun verifyUser(auth: FirebaseAuth) {
        auth.currentUser.let {
        }
    }

    private fun authUser(auth: FirebaseAuth, email: String, password: String) {
        val signInWithEmailAndPassword = auth.signInWithEmailAndPassword(email, password)
        signInWithEmailAndPassword.addOnSuccessListener {

        }
        return Unit
    }

    fun registerUser(email: String, password: String): LiveData<Boolean> {
        val liveData = MutableLiveData(false)
        val taskResultCreateUser =
            auth.createUserWithEmailAndPassword(email, password)
        taskResultCreateUser.addOnSuccessListener { AuthResultSuccess ->
            Log.i(TAG, "Usuario cadastrado com sucesso")
            liveData.postValue(true)
        }
        taskResultCreateUser.addOnFailureListener { AuthResultFailure ->
            Log.i(TAG, "Erro ao cadastrar usuário", AuthResultFailure)
        }
        return liveData
    }
}