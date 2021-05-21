const Form = () => `
<form>
    <div class="mb-3">
      <label for="form-label" class="form-label">model</label>
      <input type="form-label" class="form-control" id="form-label" name="form-label">
    </div>
  <div class="mb-3">
    <label for="esrb_rating" class="form-label">manufacturer</label>
    <input type="esrb_rating" class="form-control" id="esrb_rating" name="esrb_rating">
  </div>
  <div class="mb-3">
    <label for="description" class="form-label">memory_amount</label>
    <input type="description" class="form-control" id="description" name="description">
  </div>
  <div class="mb-3">
  <label for="price" class="form-label">processor</label>
  <input type="price" class="form-control" id="price" name="price">
</div>
<div class="mb-3">
<label for="studio" class="form-label">price</label>
<input type="studio" class="form-control" id="studio" name="studio">
</div>
<div class="mb-3">
<label for="quantity" class="form-label">quantity</label>
<input type="quantity" class="form-control" id="quantity" name="quantity">
</div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
`;
export default Form;