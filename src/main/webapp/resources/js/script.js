

addRow = function (user) {
  return `
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td class="text-right num-space">${user.balance}</td>
                <td class="text-center">
                    <a th:href="@{${user.id}}">deposit</a>
                    <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    <a th:href="@{${user.id}}">withdraw</a>
                    <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                    <a th:href="@{${user.id}}">transfer</a>
                </td>
                <td class="text-center">
                    <a th:href="@{${user.id}}" class="btn btn-primary" th:title="Edit">
                        Edit
                    </a>
                    <span>&nbsp;&nbsp;</span>
                    <a type="button" th:href="@{${user.id}}" class="btn btn-danger" th:title="Delete">
                        Delete
                    </a>
                    <span>&nbsp;&nbsp;</span>
                    <a type="button" th:href="@{${user.id}}" class="btn btn-warning"  th:title="View">
                        Info
                    </a>
                </td>
            </tr>
         `;
}

showUser = function () {
  $.ajax({
    url: "/users",
    method: "GET",
    success: function (data) {
      $(".table tbody").empty();
      data = data.sort(function (a, b) {
        return b.id - a.id;
      });
      $.each(data, (index, item) => {
        $(".table tbody").append(addRow(item));
      });
    }
  })

};

clear = function () {
  $('input[name="name"]').val("");
  $('input[name="email"]').val("");
  $('input[name="country"]').val("")
};

add = function () {
  let name = $('input[name="name"]').val();
  let email = $('input[name="email"]').val();
  let country = $('input[name="country"]').val();
  let balance = parseFloat($('input[name="balance"]').val());
  let newUser = {name, email, country, balance};

  $.ajax({
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    type: "POST",
    data: JSON.stringify(newUser),
    url: "/users",
    success: function (result) {
      console.log(result)
      if(result) {
        newUser = result;
        $(".table tbody tr:first").before(addRow(newUser));
      }
    }
  })

};

remove = function (id) {
  let user = $(this);
  let smartphoneId = user.attr("href");
  $.ajax({
    url: `/users/${id}`,
    type: "DELETE",
    success: function (result){
     user.parent().parent().remove();
    }
  })
  // Swal.fire({
  //   title: "Are you sure?",
  //   text: "You won't be able to revert this!",
  //   icon: "warning",
  //   showCancelButton: true,
  //   confirmButtonColor: "#3085d6",
  //   cancelButtonColor: "#d33",
  //   confirmButtonText: "Yes, delete it!",
  // }).then((result) => {
  //   if (result.isConfirmed) {
  //     Swal.fire("Deleted!", "Your file has been deleted.", "success");
  //     productList.splice(id, 1);
  //     // $(id).closest('tr').remove();
  //     console.log(id);
  //     showProduct();
  //   }
  //   $(".cancel").prop("disabled", true);
  // });
};

$('.btn-danger').click()
//
// update = function () {
//   let id = parseInt($('input[name="productID"]').val());
//   let newName = $('input[name="name"]').val();
//   let newBrand = $("#inlineFormCustomSelect").find(":selected").val();
//
//   if (newName == "" || newBrand == "") {
//     Swal.fire({
//       icon: "error",
//       title: "Oops...",
//       text: "No customer name!",
//     });
//     clear();
//   } else {
//     productList[id].setId(id);
//     productList[id].setName(newName);
//     productList[id].setBrand(newBrand);
//     clear();
//     showProduct();
//   }
// };
//
// select = function (id) {
//   $.each(productList, (index, item) => {
//     if (id == index) {
//       $('input[name="productID"]').val(item.id);
//       $('input[name="name"]').val(item.name);
//       $("#inlineFormCustomSelect").val(item.brand).change();
//     }
//   });
// };

// showModal = function () {
//   $('#userModal').modal('show');
// }

$(document).ready(function () {
  // showBrand();
  $(".input-group select option:first").prop('selected', true);
  showUser();
  $(".edit").click(function () {
    $(".submit").addClass("d-none");
    $(".update").removeClass("d-none");
    $(".cancel").removeAttr("disabled");
  });
  $(".cancel").click(function () {
    $(".submit").removeClass("d-none");
    $(".update").addClass("d-none");
    $(".cancel").prop("disabled", true);
    clear();
  });
});
