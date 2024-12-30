function deleteCompte(rib) {
    Swal.fire({
        title: "Êtes-vous sûr(e) ?",
        text: "Cette action supprimera le compte définitivement.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Oui, supprimer !",
        cancelButtonText: "Annuler"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "/comptes/delete-ajax",
                type: "POST",
                data: { rib: rib },
                success : function() {
                    $("#" + rib).remove();
                    Swal("Your Compte has been deleted!", {
                        icon: "success",
                    });
                },
                error: function (xhr, status, error) {
                    Swal.fire(
                        "Erreur !",
                        "Une erreur s'est produite : " + xhr.responseText,
                        "error"
                    );
                }
            });
        }
    });
}

function showSuccessAlert(){
  // show alert

}
